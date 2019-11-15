FROM oracle/graalvm-ce:19.2.1 as graalvm
COPY . /home/app/graalvm
WORKDIR /home/app/graalvm
RUN gu install native-image
RUN native-image -J-Xmx8G -J-Xms6G --no-server -cp build/libs/graalvm-*-all.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/graalvm .
ENTRYPOINT ["./graalvm"]

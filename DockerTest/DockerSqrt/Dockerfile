From alpine
RUN apk add openjdk11
ENV PATH=$PATH:/usr/lib/jvm/java-11-openjdk/bin
WORKDIR /user/here/
COPY Mk.java Mk.java
ENTRYPOINT  javac Mk.java && java Mk $NUMBER
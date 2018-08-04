FROM debian:jessie
#installing java
RUN echo 'deb http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main' > /etc/apt/sources.list.d/java-8-debian.list &&\
    echo 'deb-src http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main' >> /etc/apt/sources.list.d/java-8-debian.list &&\
    apt-key adv --keyserver keyserver.ubuntu.com --recv-keys EEA14886 &&\
    apt-get update &&\
    echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 select true" | debconf-set-selections &&\
    apt-get install -y oracle-java8-installer &&\
    apt-get install -y oracle-java8-set-default

#installing maven
RUN apt-cache search maven && apt-get install -y maven    

ADD . /var/www/html
RUN cd /var/www/html && mvn clean install
WORKDIR /var/www/html
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/BodymassIndexCalculator-0.0.1.jar"]

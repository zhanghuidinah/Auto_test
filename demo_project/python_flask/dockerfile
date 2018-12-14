FROM centos:centos7

RUN yum -y install epel-release && yum clean all
RUN yum -y install python-pip && yum clean all
RUN pip install --upgrade pip

# install network tools
RUN yum -y install net-tools bind-utils telnet && yum clean all

COPY . /root

RUN pip install -r /root/requirement.txt

EXPOSE 5000 22

WORKDIR /root

CMD ["sh", "start.sh"]


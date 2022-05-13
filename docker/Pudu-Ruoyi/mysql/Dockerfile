#设定初始镜像mysql版本
FROM mysql:5.7

#默认mysql无法输入中文，修改编码使其支持中文
ENV LANG=C.UTF-8

RUN chown -R mysql:mysql /docker-entrypoint-initdb.d/

CMD ["mysqld", "--character-set-server=utf8mb4", "--collation-server=utf8mb4_unicode_ci","--innodb-buffer-pool-size=80M","--default-time-zone=+8:00","--lower-case-table-names=1"]

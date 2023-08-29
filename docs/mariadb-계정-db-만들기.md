
1. 모든 작업은 dba(root)로 한다.
```sh
   # mysql -u root -p
```
2. 데이터베이스 생성
```sh
	MariaDB [(none)]> create database webdb;
	MariaDB [(none)]> show databases;
	MariaDB [(none)]> use webdb;
	MariaDB [webdb]>
	MariaDB [webdb]> show tables;
```

3. 계정 생성
```sh
	MariaDB [(none)]> create user 'webdb'@'192.168.%' identified by 'webdb';
	MariaDB [(none)]> create user 'webdb'@'localhost' identified by 'webdb';
	-> 192.168.% : 192.168로 시작하는 IP 접급 허용
```

3-1. 계정 삭제
```sh
	# delete from mysql.user where User ='삭제할 아이디';
	# delete from mysql.user where User ='삭제할 아이디';
	# delete from mysql.db where User ='삭제할 아이디';
	# delete from mysql.db where User ='webdb';
	# flush privileges;
```

4. 권한주기(모든 권한)
```sh
	MariaDB [(none)]> grant all privileges on webdb.* to 'webdb'@'localhost';
	MariaDB [(none)]> grant all privileges on webdb.* to 'webdb'@'192.168.%';
	MariaDB [(none)]> flush privileges;
```

5. 권한 확인
```sh
	# mysql -u webdb -D webdb -p
	user webdb가 database webdb로 접근
```

6. 
```sh
OPT_LOCAL_INFILE=1
```

# Big Data Programming for Data Analytics

Contains relevant code used for Big Data analytics assignment for PGDip Data Analytics. The assignment required building data pipelines for a large dataset of choice (>500MB) through multiple relational and non-relational databases for analysis. Specifically, this repo contains Java MapReduce code, MySQL view creation code, Bash Sqoop commands, and Hive queries.

**Dataset:** 
- [Yelp Online Dataset](https://www.yelp.com/dataset) (~3GB) - a collection of business reviews and Yelp user data representing a data-dump of 4,700,000 reviews of 156,000 businesses across a number of locations in the US.

**Databases:**
1. MySQL v5.7.20
2. HBase v1.2.6
3. Hive v2.3.2

**Workflow:**
1.	All data was loaded into MySQL from the Ubuntu Bash command line.
2.	Multiple MySQL views were created to select the data that was required for further analyses. 
3.	MySQL views were written into HBase tables using Apache Sqoop (v1.4.6) from the Ubuntu command line. Sqoop is a bulk data transfer tool used to transfer data between Apache Hadoop and structured relational databases.
4.	MapReduce analyses were completed on the data in the HBase databases and results were written into a second HBase database. MapReduce jobs were written in Java in the Eclipse (IDE) and executed from said IDE.
5.	Further MapReduce tasks were completed to write the results in the second HBase database to HDFS. Again, MapReduce jobs were written and executed in Java via the Eclipse IDE.
6.	Data was written from HDFS to the hard disk and the data visualized for reporting purposes.     







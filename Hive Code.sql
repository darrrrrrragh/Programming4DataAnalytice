CREATE TABLE businesscatHive (id string, state string, stars float, review_count int, category string)

--HIVE QUERIES

--ONE
INSERT OVERWRITE LOCAL DIRECTORY '/media/sf_SharedFolder' 
SELECT state, AVG(stars)
FROM businesscathive
WHERE category = 'Restaurants'
GROUP BY State;


--TWO
INSERT OVERWRITE LOCAL DIRECTORY '/media/sf_SharedFolder' 
SELECT state, AVG(stars)
FROM businesscathive
WHERE category = 'Shopping'
GROUP BY State;


--THREE
INSERT OVERWRITE LOCAL DIRECTORY 'media/sf_SharedFolder'
SELECT count(review_count), AVG(stars), state 
FROM businesscathive
WHERE category = 'Restaurants'
GROUP BY state;
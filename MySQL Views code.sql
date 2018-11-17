--MYSQL Views for project:

--BUSINESS DATA:

CREATE VIEW businesscat AS
SELECT DISTINCT business.id, business.state, business.stars, business.review_count, category.category
FROM business
JOIN category ON business.id = category.business_id

--USER DATA:

CREATE VIEW users2016 AS
SELECT user.id, user.review_count, user.useful, user.funny, user.cool, user.fans, user.average_stars, user.yelping_since
FROM user
WHERE user.yelping_since BETWEEN '2016-01-01 00:00:00' AND '2017-01-01 00:00:00'

CREATE VIEW users2015 AS
SELECT user.id, user.review_count, user.useful, user.funny, user.cool, user.fans, user.average_stars, user.yelping_since
FROM user
WHERE user.yelping_since BETWEEN '2015-01-01 00:00:00' AND '2016-01-01 00:00:00'
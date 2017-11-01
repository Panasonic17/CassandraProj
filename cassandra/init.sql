CREATE KEYSPACE youtube WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 2 };

USE youtube;

CREATE TABLE video_statistics (
    id text,
    published_at text,
    title text,
    description text,
    channel_title text,
    tags list<text>,
    view_count int,
    like_count int,
    dislike_count int,
    PRIMARY KEY ((channel_title),id)
);

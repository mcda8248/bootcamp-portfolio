CREATE SCHEMA traveljournal;

CREATE TABLE traveljournal.users ( 
	id                   int  NOT NULL  AUTO_INCREMENT,
	username             varchar(20)  NOT NULL  ,
	email                varchar(40)    ,
	password             varchar(20)  NOT NULL  ,
	CONSTRAINT pk_users PRIMARY KEY ( id )
 ) engine=InnoDB;

CREATE TABLE traveljournal.trip ( 
	id                   int  NOT NULL  AUTO_INCREMENT,
	user_id              int  NOT NULL  ,
	CONSTRAINT pk_trip PRIMARY KEY ( id )
 ) engine=InnoDB;

CREATE INDEX idx_trip ON traveljournal.trip ( user_id );

CREATE TABLE traveljournal.location ( 
	id                   int  NOT NULL  AUTO_INCREMENT,
	trip_id              int  NOT NULL  ,
	CONSTRAINT pk_location PRIMARY KEY ( id )
 ) engine=InnoDB;

CREATE INDEX idx_location ON traveljournal.location ( trip_id );

CREATE TABLE traveljournal.`text` ( 
	id                   int  NOT NULL  AUTO_INCREMENT,
	bigtext              varchar(250)  NOT NULL  ,
	location_id          int  NOT NULL  ,
	CONSTRAINT pk_text PRIMARY KEY ( id )
 ) engine=InnoDB;

CREATE INDEX idx_text ON traveljournal.`text` ( location_id );

CREATE TABLE traveljournal.video ( 
	id                   int  NOT NULL  ,
	video_src            long varchar  NOT NULL  ,
	video_text           long varchar    ,
	location_id          int  NOT NULL  ,
	CONSTRAINT pk_video PRIMARY KEY ( id )
 ) engine=InnoDB;

CREATE INDEX idx_video ON traveljournal.video ( location_id );

CREATE TABLE traveljournal.audio ( 
	id                   int  NOT NULL  AUTO_INCREMENT,
	audio_src            long varchar  NOT NULL  ,
	audio_text           long varchar    ,
	location_id          int  NOT NULL  ,
	CONSTRAINT pk_audio PRIMARY KEY ( id )
 ) engine=InnoDB;

CREATE INDEX idx_audio ON traveljournal.audio ( location_id );

CREATE TABLE traveljournal.country_logo ( 
	id                   int  NOT NULL  AUTO_INCREMENT,
	img_src              long varchar  NOT NULL  ,
	location_id          int  NOT NULL  ,
	CONSTRAINT pk_country_logo PRIMARY KEY ( id )
 ) engine=InnoDB;

CREATE INDEX idx_country_logo ON traveljournal.country_logo ( location_id );

CREATE TABLE traveljournal.images ( 
	id                   int  NOT NULL  AUTO_INCREMENT,
	img_src              long varchar  NOT NULL  ,
	img_text             long varchar    ,
	location_id          int  NOT NULL  ,
	CONSTRAINT pk_images PRIMARY KEY ( id )
 ) engine=InnoDB;

CREATE INDEX idx_images ON traveljournal.images ( location_id );

ALTER TABLE traveljournal.audio ADD CONSTRAINT fk_audio FOREIGN KEY ( location_id ) REFERENCES traveljournal.location( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE traveljournal.country_logo ADD CONSTRAINT fk_country_logo FOREIGN KEY ( location_id ) REFERENCES traveljournal.location( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE traveljournal.images ADD CONSTRAINT fk_images FOREIGN KEY ( location_id ) REFERENCES traveljournal.location( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE traveljournal.location ADD CONSTRAINT fk_location_4 FOREIGN KEY ( trip_id ) REFERENCES traveljournal.trip( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE traveljournal.`text` ADD CONSTRAINT fk_text FOREIGN KEY ( location_id ) REFERENCES traveljournal.location( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE traveljournal.trip ADD CONSTRAINT fk_trip_0 FOREIGN KEY ( user_id ) REFERENCES traveljournal.users( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE traveljournal.video ADD CONSTRAINT fk_video FOREIGN KEY ( location_id ) REFERENCES traveljournal.location( id ) ON DELETE NO ACTION ON UPDATE NO ACTION;


BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "android_metadata" (
	"locale"	TEXT
);
CREATE TABLE IF NOT EXISTS "AppInfo" (
	"appID"	INTEGER NOT NULL,
	"totalTopics"	INTEGER NOT NULL,
	"totalChapters"	INTEGER NOT NULL,
	PRIMARY KEY("appID")
);
CREATE TABLE IF NOT EXISTS "UserInfo" (
	"userID"	INTEGER NOT NULL,
	"name"	TEXT,
	"progressOverall"	INTEGER NOT NULL,
	"progressChapter"	INTEGER NOT NULL,
	"progressTopic"	INTEGER NOT NULL,
	"appID"	INTEGER NOT NULL,
	FOREIGN KEY("appID") REFERENCES "AppInfo"("appID") ON UPDATE NO ACTION ON DELETE CASCADE,
	PRIMARY KEY("userID")
);
CREATE TABLE IF NOT EXISTS "Chapter" (
	"chapterID"	INTEGER NOT NULL,
	"chapterNumber"	INTEGER NOT NULL,
	"chapterName"	TEXT,
	"appID"	INTEGER NOT NULL,
	"completedChapter"	INTEGER NOT NULL,
	FOREIGN KEY("appID") REFERENCES "AppInfo"("appID") ON UPDATE NO ACTION ON DELETE CASCADE,
	PRIMARY KEY("chapterID")
);
CREATE TABLE IF NOT EXISTS "Topic" (
	"topicID"	INTEGER NOT NULL,
	"topicNumber"	INTEGER NOT NULL,
	"topicName"	TEXT,
	"chapterID"	INTEGER NOT NULL,
	"completedTopic"	INTEGER NOT NULL,
	FOREIGN KEY("chapterID") REFERENCES "Chapter"("chapterID") ON UPDATE NO ACTION ON DELETE CASCADE,
	PRIMARY KEY("topicID")
);
CREATE TABLE IF NOT EXISTS "Quiz" (
	"quizID"	INTEGER NOT NULL,
	"quizName"	TEXT,
	"topicID"	INTEGER NOT NULL,
	"hasPassed"	INTEGER NOT NULL,
	FOREIGN KEY("topicID") REFERENCES "Topic"("topicID") ON UPDATE NO ACTION ON DELETE CASCADE,
	PRIMARY KEY("quizID")
);
CREATE TABLE IF NOT EXISTS "Question" (
	"questionID"	INTEGER NOT NULL,
	"quizID"	INTEGER NOT NULL,
	"question"	TEXT,
	"option1"	TEXT,
	"option2"	TEXT,
	"option3"	TEXT,
	"option4"	TEXT,
	"selection"	INTEGER NOT NULL,
	FOREIGN KEY("quizID") REFERENCES "Quiz"("quizID") ON UPDATE NO ACTION ON DELETE CASCADE,
	PRIMARY KEY("questionID")
);
CREATE TABLE IF NOT EXISTS "Answer" (
	"answerID"	INTEGER NOT NULL,
	"questionID"	INTEGER NOT NULL,
	"answer"	INTEGER NOT NULL,
	"isCorrect"	INTEGER NOT NULL,
	FOREIGN KEY("questionID") REFERENCES "Question"("questionID") ON UPDATE NO ACTION ON DELETE CASCADE,
	PRIMARY KEY("answerID")
);
CREATE TABLE IF NOT EXISTS "room_master_table" (
	"id"	INTEGER,
	"identity_hash"	TEXT,
	PRIMARY KEY("id")
);
INSERT INTO "android_metadata" VALUES ('en_US');
INSERT INTO "AppInfo" VALUES (1,3,1);
INSERT INTO "room_master_table" VALUES (42,'1c061f704c82d7f768f380e71087748d');
CREATE INDEX IF NOT EXISTS "index_UserInfo_appID" ON "UserInfo" (
	"appID"
);
CREATE INDEX IF NOT EXISTS "index_Chapter_appID" ON "Chapter" (
	"appID"
);
CREATE INDEX IF NOT EXISTS "index_Topic_chapterID" ON "Topic" (
	"chapterID"
);
CREATE INDEX IF NOT EXISTS "index_Quiz_topicID" ON "Quiz" (
	"topicID"
);
CREATE INDEX IF NOT EXISTS "index_Question_quizID" ON "Question" (
	"quizID"
);
CREATE INDEX IF NOT EXISTS "index_Answer_questionID" ON "Answer" (
	"questionID"
);
COMMIT;

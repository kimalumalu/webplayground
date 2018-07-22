# \connect "webplayground";

DROP TABLE IF EXISTS "bmi_report";
DROP SEQUENCE IF EXISTS bmi_report_id_seq;
CREATE SEQUENCE bmi_report_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1;

CREATE TABLE "public"."bmi_report" (
    "report_id" integer DEFAULT nextval('bmi_report_id_seq') NOT NULL,
    "current_index" integer DEFAULT '0' NOT NULL,
    "ideal_index" integer DEFAULT '0' NOT NULL,
    "current_weight" double precision DEFAULT '0' NOT NULL,
    "ideal_weight" integer DEFAULT '0' NOT NULL,
    "weight_to_lose" integer DEFAULT '0' NOT NULL,
    "time" timestamp NOT NULL,
    CONSTRAINT "bmi_report_id" PRIMARY KEY ("report_id")
) WITH (oids = false);
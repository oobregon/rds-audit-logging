#main.tf
#defining the provider as aws
provider "aws" {
    region     = "${var.region}"
    access_key = "${var.access_key}"
    secret_key = "${var.secret_key}"
}



#create a RDS Database Instance
resource "aws_db_instance" "logging-events" {
  engine               = "Postgres"
  identifier           = "logging-events"
  allocated_storage    =  20
  engine_version       = "9.16.12"
  instance_class       = "db.t3.micro"
  username             = "postgres"
  password             = "postgres"
  skip_final_snapshot  = true
  publicly_accessible =  true
}
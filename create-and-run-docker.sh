#!/usr/bin/env bash
echo "starting web playground"
echo "initializing laravel environment"
echo "change to laravelicious folder"
cd laravelicious
echo "set up laravel environment file"
cp .env.example .env
echo "initialize laravel dependencies with composer"
composer install
echo "set up laravel configurations"
php artisan key:generate
php artisan config:clear
echo "starting php webserver"
php artisan serve &
echo "change back to root folder"
cd ..
echo "initializing spring environment with maven"
mvn clean install --file ./springylicious/bodymassindex/pom.xml
echo "starting docker containers with docker-compose"
docker-compose up

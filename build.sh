#!/usr/bin/env bash
set -e

function sub_run_service() {
  java -jar target/seller-service-1.0.0.jar
}
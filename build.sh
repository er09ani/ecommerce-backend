#!/usr/bin/env bash
set -e

function sub_run_seller_service() {
  java -jar seller-service/target/seller-service-1.0.0.jar
}

function hello(){
  echo "hi"
}

sub_command=$1
program_name=$(basename "$0")

function sub_help() {
  read -r -d ';' usage <<EOM
  Usage: $program_name <sub_command> [options]
  sub_command:
  run_service: run the application
  for help
  $program_name <sub_command> -h
;
EOM
  echo "$usage"
}

case $sub_command in
"" | "-h" | "--help")
  sub_help
  ;;
*)
  shift
  sub_"$sub_command" "$@"
  exit_code=$?
  if [[ $exit_code == 127 ]]; then
    printf "Error: unknown command %s\n" "$sub_command" >&2
    printf " Run '%s --help' for list of sub commands\n" "$program_name" >&2
    exit 1
  elif [[ $exit_code != 0 ]]; then
    exit $exit_code
  fi
  ;;
esac
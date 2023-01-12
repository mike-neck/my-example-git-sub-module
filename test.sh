#!/usr/bin/env bash

[[ "$(cat ./test.txt | wc -l)" -lt 10  ]] || echo "error" | tee /dev/stderr | grep -q -v error


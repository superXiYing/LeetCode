#!/bin/bash
git checkout > ./tmp/gitCheckout.out
input="./tmp/gitCheckout.out"
while IFS=$'/t' read -r -a line
do
echo "git add ${line[1]}
git add ${line[1]}
done < "$input"

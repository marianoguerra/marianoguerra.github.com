#!/usr/bin/env python
import sys
import json

if __name__ == "__main__":
    data = json.load(open(sys.argv[1]))
    print json.dumps(data, sort_keys=True, indent=4)


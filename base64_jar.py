import base64

with open("build/libs/eldermob-1.0-SNAPSHOT.jar", "rb") as f:
    base64_code = base64.b64encode(f.read())

with open("test.jar", "wb") as f:
    f.write(base64.b64decode(base64_code))

"""
S1. 检查事件和分支：TRAVIS_BRANCH以及TRAVIS_EVENT_TYPE，通过TRAVIS_TEST_RESULT
获取构建结果
S2. 确定当前branch，如果是dev并且是push，则继续往下执行，其余情况则忽略
S3. 解析收集JUnit的测试结果。
S4. 解析收集FindBugs的测试结果。
S5. 上传构建好的Jar包到指定位置，并获取Jar包的上传地址。
S6. 回调TravisJob (如何确定当前的Flow instance id)
"""

from os import environ

print("====================================================")
for var_name in ("TRAVIS_BRANCH", "TRAVIS_EVENT_TYPE",
                 "TRAVIS_TEST_RESULT", "TRAVIS_COMMIT",
                 "TRAVIS_COMMIT_RANGE"):
    print("{} = {}".format(var_name, environ[var_name]))

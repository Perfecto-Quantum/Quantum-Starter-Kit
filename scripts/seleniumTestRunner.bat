chdir /d %~dp0 
cd ..
ant -f scripts/seleniumtestrunner.xml -Dtestng.suite.file=testrun_config.xml

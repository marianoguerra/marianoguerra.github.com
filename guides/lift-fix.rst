
* fork lift clicking in the fork button on https://github.com/lift/framework
* clone your forked repo to your computer (in my case)::

	[mariano@ganesha soft]$ git clone git@github.com:marianoguerra/framework.git
	Cloning into framework...
	remote: Counting objects: 27804, done.
	remote: Compressing objects: 100% (8536/8536), done.
	remote: Total 27804 (delta 11503), reused 27537 (delta 11268)
	Receiving objects: 100% (27804/27804), 5.18 MiB | 291 KiB/s, done.
	Resolving deltas: 100% (11503/11503), done.

* follow the steps in the "Building Lift" section of the README::

	cd framework
	./liftsh +publish

* after some errors I run this trying to fix the errors::

	./liftsh clean-plugins reload clean-cache clean-lib update

* trying to run the tests of the part I'm interested::

	./liftsh "project lift-couchdb" test

(seems to run all the tests anyway)


* edit framework/persistence/couchdb/src/main/scala/net/liftweb/couchdb/Database.scala
* apply the change suggested here: http://www.assembla.com/spaces/liftweb/tickets/961
* run the tests after the fix... they pass!
* commit https://github.com/marianoguerra/framework/commit/e0d8432ed81c8a51d19486f981fafb9ed3cbb982
* push to my repo at github https://github.com/marianoguerra/framework/tree/fix-961
* make a pull request https://github.com/lift/framework/pull/10
* wait for the veredict

related tests before the patch::

	[error] x A couch record should
	[info]   + give emtpy box on get when nonexistant
	[error]   x be insertable
	[error]     'false' is not equal to 'true' (CouchRecordSpec.scala:104)
	[error]   x generate the right JSON
	[error]     Trying to open an empty Box (Box.scala:572)
	[error]     net.liftweb.common.EmptyBox.open_$bang(Box.scala:572)
	[error]     net.liftweb.common.EmptyBox.open_$bang(Box.scala:557)
	[error]     net.liftweb.couchdb.CouchRecordSpec$$anonfun$5$$anonfun$apply$42.apply(CouchRecordSpec.scala:120)
	[error]     net.liftweb.couchdb.CouchRecordSpec$$anonfun$5$$anonfun$apply$42.apply(CouchRecordSpec.scala:115)
	[error]     org.specs.specification.LifeCycle$class.withCurrent(ExampleLifeCycle.scala:66)
	[error]     org.specs.specification.Examples.withCurrent(Examples.scala:52)
	[error]     org.specs.specification.Examples$$anonfun$specifyExample$1.apply(Examples.scala:114)
	[error]     org.specs.specification.Examples$$anonfun$specifyExample$1.apply(Examples.scala:114)
	[error]     org.specs.specification.ExampleExecution$$anonfun$3$$anonfun$apply$5.apply(ExampleLifeCycle.scala:219)
	[error]     scala.Option.getOrElse(Option.scala:104)
	[error]     org.specs.specification.LifeCycle$class.executeExpectations(ExampleLifeCycle.scala:90)
	[error]     org.specs.specification.BaseSpecification.executeExpectations(BaseSpecification.scala:58)
	[error]     org.specs.specification.LifeCycle$$anonfun$executeExpectations$1.apply(ExampleLifeCycle.scala:90)
	[error]     org.specs.specification.LifeCycle$$anonfun$executeExpectations$1.apply(ExampleLifeCycle.scala:90)
	[error]     scala.Option.map(Option.scala:129)
	[error]     org.specs.specification.LifeCycle$class.executeExpectations(ExampleLifeCycle.scala:90)
	[error]     org.specs.specification.BaseSpecification.executeExpectations(BaseSpecification.scala:58)
	[error]     org.specs.specification.ExampleContext$$anonfun$executeExpectations$3$$anonfun$apply$3$$anonfun$apply$4.apply(ExampleContext.scala:81)
	[error]     org.specs.specification.ExampleContext$$anonfun$executeExpectations$3$$anonfun$apply$3$$anonfun$apply$4.apply(ExampleContext.scala:81)
	[error]     scala.Option.map(Option.scala:129)
	[error]     org.specs.specification.ExampleContext$$anonfun$executeExpectations$3$$anonfun$apply$3.apply(ExampleContext.scala:81)
	[error]     org.specs.specification.ExampleContext$$anonfun$executeExpectations$3$$anonfun$apply$3.apply(ExampleContext.scala:81)
	[error]     org.specs.specification.ExampleContext$class.id$1(ExampleContext.scala:32)
	[error]     org.specs.specification.ExampleContext$$anonfun$1.apply(ExampleContext.scala:33)
	[error]     org.specs.specification.ExampleContext$$anonfun$1.apply(ExampleContext.scala:33)
	[error]     org.specs.specification.ExampleContext$$anonfun$executeExpectations$3.apply(ExampleContext.scala:81)
	[error]     org.specs.specification.ExampleContext$$anonfun$executeExpectations$3.apply(ExampleContext.scala:80)
	[error]     scala.Option.map(Option.scala:129)
	[error]     org.specs.specification.ExampleContext$class.executeExpectations(ExampleContext.scala:80)
	[error]     org.specs.specification.Examples.executeExpectations(Examples.scala:52)
	[error]     org.specs.specification.ExampleContext$$anonfun$executeExpectations$3$$anonfun$apply$3$$anonfun$apply$4.apply(ExampleContext.scala:81)
	[error]     org.specs.specification.ExampleContext$$anonfun$executeExpectations$3$$anonfun$apply$3$$anonfun$apply$4.apply(ExampleContext.scala:81)
	[error]     scala.Option.map(Option.scala:129)
	[error]     org.specs.specification.ExampleContext$$anonfun$executeExpectations$3$$anonfun$apply$3.apply(ExampleContext.scala:81)
	[error]     org.specs.specification.ExampleContext$$anonfun$executeExpectations$3$$anonfun$apply$3.apply(ExampleContext.scala:81)
	[error]     org.specs.specification.ExampleContext$class.id$1(ExampleContext.scala:32)
	[error]     org.specs.specification.ExampleContext$$anonfun$1.apply(ExampleContext.scala:33)
	[error]     org.specs.specification.ExampleContext$$anonfun$1.apply(ExampleContext.scala:33)
	[error]     org.specs.specification.ExampleContext$$anonfun$executeExpectations$3.apply(ExampleContext.scala:81)
	[error]     org.specs.specification.ExampleContext$$anonfun$executeExpectations$3.apply(ExampleContext.scala:80)
	[error]     scala.Option.map(Option.scala:129)
	[error]     org.specs.specification.ExampleContext$class.executeExpectations(ExampleContext.scala:80)
	[error]     org.specs.specification.Examples.executeExpectations(Examples.scala:52)
	[error]     org.specs.specification.ExampleExecution$$anonfun$3.apply(ExampleLifeCycle.scala:219)
	[error]     org.specs.specification.ExampleExecution$$anonfun$3.apply(ExampleLifeCycle.scala:198)
	[error]     org.specs.specification.ExampleExecution$$anonfun$2.apply(ExampleLifeCycle.scala:181)
	[error]     org.specs.specification.ExampleExecution.execute(ExampleLifeCycle.scala:252)
	[error]     org.specs.specification.SpecificationExecutor$$anonfun$executeExample$2.apply(SpecificationExecutor.scala:55)
	[error]     org.specs.specification.SpecificationExecutor$$anonfun$executeExample$2.apply(SpecificationExecutor.scala:55)
	[error]     scala.Option.map(Option.scala:129)
	[error]     org.specs.specification.SpecificationExecutor$class.executeExample(SpecificationExecutor.scala:55)
	[error]     org.specs.specification.BaseSpecification.executeExample(BaseSpecification.scala:58)
	[error]     org.specs.specification.BaseSpecification.executeExample(BaseSpecification.scala:58)
	[error]     org.specs.specification.ExampleLifeCycle$$anonfun$executeExample$1.apply(ExampleLifeCycle.scala:125)
	[error]     org.specs.specification.ExampleLifeCycle$$anonfun$executeExample$1.apply(ExampleLifeCycle.scala:125)
	[error]     scala.Option.map(Option.scala:129)
	[error]     org.specs.specification.ExampleLifeCycle$class.executeExample(ExampleLifeCycle.scala:125)
	[error]     org.specs.specification.Examples.executeExample(Examples.scala:52)
	[error]     org.specs.specification.Examples.executeExample(Examples.scala:52)
	[error]     org.specs.specification.Examples$$anonfun$executeExamples$2.apply(Examples.scala:80)
	[error]     org.specs.specification.Examples$$anonfun$executeExamples$2.apply(Examples.scala:80)
	[error]     scala.Option.map(Option.scala:129)
	[error]     org.specs.specification.Examples.executeExamples(Examples.scala:80)
	[error]     org.specs.specification.ExampleStructure$class.ownFailures(ExampleStructure.scala:58)
	[error]     org.specs.specification.Examples.ownFailures(Examples.scala:52)
	[error]     org.specs.specification.ExampleStructure$class.failures(ExampleStructure.scala:64)
	[error]     org.specs.specification.Examples.failures(Examples.scala:52)
	[error]     org.specs.specification.ExampleStructure$$anonfun$failures$1.apply(ExampleStructure.scala:64)
	[error]     org.specs.specification.ExampleStructure$$anonfun$failures$1.apply(ExampleStructure.scala:64)
	[error]     scala.collection.TraversableLike$$anonfun$flatMap$1.apply(TraversableLike.scala:227)
	[error]     scala.collection.TraversableLike$$anonfun$flatMap$1.apply(TraversableLike.scala:227)
	[error]     scala.collection.LinearSeqOptimized$class.foreach(LinearSeqOptimized.scala:61)
	[error]     scala.collection.immutable.List.foreach(List.scala:45)
	[error]     scala.collection.TraversableLike$class.flatMap(TraversableLike.scala:227)
	[error]     scala.collection.immutable.List.flatMap(List.scala:45)
	[error]     org.specs.specification.ExampleStructure$class.failures(ExampleStructure.scala:64)
	[error]     org.specs.specification.Examples.failures(Examples.scala:52)
	[error]     org.specs.specification.Examples.failures(Examples.scala:52)
	[error]     org.specs.execute.HasResults$class.failureAndErrors(HasResults.scala:61)
	[error]     org.specs.specification.Examples.failureAndErrors(Examples.scala:52)
	[error]     org.specs.execute.HasResults$class.isOk(HasResults.scala:69)
	[error]     org.specs.specification.Examples.isOk(Examples.scala:52)
	[error]     org.specs.runner.NotifierRunner.reportSystem(NotifierRunner.scala:81)
	[error]     org.specs.runner.NotifierRunner$$anonfun$reportASpecification$3.apply(NotifierRunner.scala:72)
	[error]     org.specs.runner.NotifierRunner$$anonfun$reportASpecification$3.apply(NotifierRunner.scala:68)
	[error]     scala.collection.LinearSeqOptimized$class.foreach(LinearSeqOptimized.scala:61)
	[error]     scala.collection.immutable.List.foreach(List.scala:45)
	[error]     org.specs.runner.NotifierRunner.reportASpecification(NotifierRunner.scala:68)
	[error]     org.specs.runner.NotifierRunner.report(NotifierRunner.scala:58)
	[error]     org.specs.runner.NotifierRunner.report(NotifierRunner.scala:45)
	[error]     org.specs.runner.Reporter$class.reportSpecs(Reporter.scala:195)
	[error]     org.specs.runner.NotifierRunner.reportSpecs(NotifierRunner.scala:45)
	[error]     org.specs.runner.TestInterfaceRunner$$anonfun$run$3.apply(TestInterfaceRunner.scala:72)
	[error]     org.specs.runner.TestInterfaceRunner$$anonfun$run$3.apply(TestInterfaceRunner.scala:72)
	[error]     scala.Option.map(Option.scala:129)
	[error]     org.specs.runner.TestInterfaceRunner.run(TestInterfaceRunner.scala:72)
	[error]     org.specs.runner.TestInterfaceRunner.run(TestInterfaceRunner.scala:65)
	[error]     sbt.TestRunner.run(TestFramework.scala:53)
	[error]     sbt.TestRunner.runTest$1(TestFramework.scala:67)
	[error]     sbt.TestRunner.run(TestFramework.scala:76)
	[error]     sbt.TestFramework$$anonfun$10$$anonfun$apply$11.runTest$2(TestFramework.scala:194)
	[error]     sbt.TestFramework$$anonfun$10$$anonfun$apply$11$$anonfun$apply$12.apply(TestFramework.scala:205)
	[error]     sbt.TestFramework$$anonfun$10$$anonfun$apply$11$$anonfun$apply$12.apply(TestFramework.scala:205)
	[error]     sbt.NamedTestTask.run(TestFramework.scala:92)
	[error]     sbt.ScalaProject$$anonfun$sbt$ScalaProject$$toTask$1.apply(ScalaProject.scala:193)
	[error]     sbt.ScalaProject$$anonfun$sbt$ScalaProject$$toTask$1.apply(ScalaProject.scala:193)
	[error]     sbt.TaskManager$Task.invoke(TaskManager.scala:62)
	[error]     sbt.impl.RunTask.doRun$1(RunTask.scala:77)
	[error]     sbt.impl.RunTask.runTask(RunTask.scala:85)
	[error]     sbt.impl.RunTask.sbt$impl$RunTask$$runIfNotRoot(RunTask.scala:60)
	[error]     sbt.impl.RunTask$$anonfun$runTasksExceptRoot$2.apply(RunTask.scala:48)
	[error]     sbt.impl.RunTask$$anonfun$runTasksExceptRoot$2.apply(RunTask.scala:48)
	[error]     sbt.Distributor$Run$Worker$$anonfun$2.apply(ParallelRunner.scala:131)
	[error]     sbt.Distributor$Run$Worker$$anonfun$2.apply(ParallelRunner.scala:131)
	[error]     sbt.Control$.trapUnit(Control.scala:19)
	[error]     sbt.Distributor$Run$Worker.run(ParallelRunner.scala:131)
	[error]   x be deletable
	[error]     Empty doesn't verify the expected property (CouchRecordSpec.scala:129)
	[error]   x be fetchable in bulk
	[error]     'false' is not equal to 'true' (CouchRecordSpec.scala:150)
	[error]   x support queries
	[error]     'false' is not equal to 'true' (CouchRecordSpec.scala:170)
	[error]   x support queries returning documents
	[error]     'false' is not equal to 'true' (CouchRecordSpec.scala:189)
	[error]   x support queries returning documents for a non-reducing view
	[error]     'false' is not equal to 'true' (CouchRecordSpec.scala:207)
	[error]   x support multiple databases for fetching
	[error]     'false' is not equal to 'true' (CouchRecordSpec.scala:227)
	[error]   x support multiple databases for fetching in bulk
	[error]     'false' is not equal to 'true' (CouchRecordSpec.scala:253)
	[error]   x support multiple databases for queries
	[error]     'false' is not equal to 'true' (CouchRecordSpec.scala:282)
	[error]   x support multiple databases for queries returning documents
	[error]     'false' is not equal to 'true' (CouchRecordSpec.scala:309)
	[info] == lift-couchdb / net.liftweb.couchdb.CouchRecordSpec ==
	[info]
	[info] == lift-couchdb / net.liftweb.couchdb.CouchQuerySpec ==
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	[error] x Queries should
	[error]   x work with all documents
	[error]     Failure(ok not present in reply or not true: JObject(List(JField(ok,JBool(true)), JField(id,JString(_design/test)), JField(rev,JString(1-e7745b5f2af5ae7abb4d304c19e81e91)))),Empty,Empty) doesn't verify the expected property (CouchQuerySpec.scala:42)
	[error]   x support multi-document fetch
	[error]     Failure(ok not present in reply or not true: JObject(List(JField(ok,JBool(true)), JField(id,JString(_design/test)), JField(rev,JString(1-e7745b5f2af5ae7abb4d304c19e81e91)))),Empty,Empty) doesn't verify the expected property (CouchQuerySpec.scala:42)
	[error]   x work with views
	[error]     Failure(ok not present in reply or not true: JObject(List(JField(ok,JBool(true)), JField(id,JString(_design/test)), JField(rev,JString(1-e7745b5f2af5ae7abb4d304c19e81e91)))),Empty,Empty) doesn't verify the expected property (CouchQuerySpec.scala:42)
	[error]   x support minimum key bounds
	[error]     Failure(ok not present in reply or not true: JObject(List(JField(ok,JBool(true)), JField(id,JString(_design/test)), JField(rev,JString(1-e7745b5f2af5ae7abb4d304c19e81e91)))),Empty,Empty) doesn't verify the expected property (CouchQuerySpec.scala:42)
	[error]   x support maximum key bounds
	[error]     Failure(ok not present in reply or not true: JObject(List(JField(ok,JBool(true)), JField(id,JString(_design/test)), JField(rev,JString(1-e7745b5f2af5ae7abb4d304c19e81e91)))),Empty,Empty) doesn't verify the expected property (CouchQuerySpec.scala:42)
	[error]   x support key lookup
	[error]     Failure(ok not present in reply or not true: JObject(List(JField(ok,JBool(true)), JField(id,JString(_design/test)), JField(rev,JString(1-e7745b5f2af5ae7abb4d304c19e81e91)))),Empty,Empty) doesn't verify the expected property (CouchQuerySpec.scala:42)
	[error]   x support limiting the number of results
	[error]     Failure(ok not present in reply or not true: JObject(List(JField(ok,JBool(true)), JField(id,JString(_design/test)), JField(rev,JString(1-e7745b5f2af5ae7abb4d304c19e81e91)))),Empty,Empty) doesn't verify the expected property (CouchQuerySpec.scala:42)
	[error]   x support descending sort
	[error]     Failure(ok not present in reply or not true: JObject(List(JField(ok,JBool(true)), JField(id,JString(_design/test)), JField(rev,JString(1-e7745b5f2af5ae7abb4d304c19e81e91)))),Empty,Empty) doesn't verify the expected property (CouchQuerySpec.scala:42)
	[error]   x preserve query ordering
	[error]     Failure(ok not present in reply or not true: JObject(List(JField(ok,JBool(true)), JField(id,JString(_design/test)), JField(rev,JString(1-e7745b5f2af5ae7abb4d304c19e81e91)))),Empty,Empty) doesn't verify the expected property (CouchQuerySpec.scala:42)
	[info] == lift-couchdb / net.liftweb.couchdb.CouchQuerySpec ==
	[info]
	[info] == lift-couchdb / net.liftweb.couchdb.JsonRecordSpec ==
	[info] + A JSON record should
	[info]   + encode basic records correctly
	[info]   + encode record with subrecord correctly
	[info]   + decode basic records correctly
	[info]   + preserve extra fields from JSON
	[info]   + support unset optional fields
	[info]   + support set optional fields
	[info]   + support set subRecord field
	[info]   + not set missing fields
	[info]   + honor overrideIgnoreExtraJSONFields == true
	[info]   + honor overrideIgnoreExtraJSONFields == false
	[info]   + honor overrideNeedAllJSONFields == true
	[info]   + honor overrideNeedAllJSONFields == false
	[info] == lift-couchdb / net.liftweb.couchdb.JsonRecordSpec ==
	[info]
	[info] == lift-couchdb / net.liftweb.couchdb.CouchDocumentSpec ==
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/testdoc
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/test
	[error] x A document should
	[info]   + give 404 on get when nonexistant
	[error]   x be insertable
	[error]     Failure(ok not present in reply or not true: JObject(List(JField(ok,JBool(true)), JField(id,JString(969915a67b93a57eccfbb0d9f000acd8)), JField(rev,JString(1-4cf33f8f525cc335684f957457867465)))),Empty,Empty) doesn't verify the expected property (CouchDocumentSpec.scala:43)
	[error]   x have history
	[error]     Failure(ok not present in reply or not true: JObject(List(JField(ok,JBool(true)), JField(id,JString(969915a67b93a57eccfbb0d9f000aed5)), JField(rev,JString(1-4cf33f8f525cc335684f957457867465)))),Empty,Empty) doesn't verify the expected property (CouchDocumentSpec.scala:72)
	[error]   x be deletable
	[error]     Failure(ok not present in reply or not true: JObject(List(JField(ok,JBool(true)), JField(id,JString(969915a67b93a57eccfbb0d9f000b17d)), JField(rev,JString(1-4cf33f8f525cc335684f957457867465)))),Empty,Empty) doesn't verify the expected property (CouchDocumentSpec.scala:43)
	[error]   x give 404 on delete when nonexistant
	[error]     Failure(ok not present in reply or not true: JObject(List(JField(ok,JBool(true)), JField(id,JString(969915a67b93a57eccfbb0d9f000b8e0)), JField(rev,JString(1-4cf33f8f525cc335684f957457867465)))),Empty,Empty) doesn't verify the expected property (CouchDocumentSpec.scala:43)
	[error]   x be force storable
	[error]     Failure(ok not present in reply or not true: JObject(List(JField(ok,JBool(true)), JField(id,JString(test)), JField(rev,JString(1-4cf33f8f525cc335684f957457867465)))),Empty,Empty) doesn't verify the expected property (CouchDocumentSpec.scala:43)
	[info] == lift-couchdb / net.liftweb.couchdb.CouchDocumentSpec ==
	[info]
	[info] == lift-couchdb / Test cleanup 1 ==
	[info] Deleting directory /tmp/sbt_416e7e8b
	[info] == lift-couchdb / Test cleanup 1 ==
	[info]
	[info] == lift-couchdb / test-finish ==
	[error] Error: Total 51, Failed 27, Errors 1, Passed 23, Skipped 0
	[info] == lift-couchdb / test-finish ==
	[info]
	[info] == lift-couchdb / test-cleanup ==
	[info] == lift-couchdb / test-cleanup ==
	[error] Error running net.liftweb.couchdb.CouchRecordSpec: ERROR occurred during testing.
	[error] Error running net.liftweb.couchdb.CouchQuerySpec: Test FAILED
	[error] Error running net.liftweb.couchdb.CouchDocumentSpec: Test FAILED
	[error] Error running test: One or more subtasks failed
	[info]
	[info] Total time: 46 s, completed Nov 3, 2011 4:51:11 PM
	[info]
	[info] Total session time: 47 s, completed Nov 3, 2011 4:51:11 PM
	[error] Error during build.
	2011-11-03 16:51:11,144 [Shutdown] INFO org.mortbay.log - Shutdown hook executing
	2011-11-03 16:51:11,144 [Shutdown] INFO org.mortbay.log - Shutdown hook complete
	2011-11-03 16:51:12,144 [Shutdown] INFO org.mortbay.log - Shutdown hook complete


related tests after the patch::

	[info] == lift-couchdb / test-start ==
	[info] == lift-couchdb / test-start ==
	[info]
	[info] == lift-couchdb / net.liftweb.couchdb.CouchDatabaseSpec ==
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	[info] + A database should
	[info]   + give 404 when info called and nonexistant
	[info]   + give 404 when deleted but nonexistant
	[info]   + succeed being created
	[info]   + give 412 instead of allowing creation when already existant
	[info]   + have info when created
	[info]   + succeed in being deleted
	[info]   + succeed being recreated
	[info] == lift-couchdb / net.liftweb.couchdb.CouchDatabaseSpec ==
	[info]
	[info] == lift-couchdb / net.liftweb.couchdb.CouchQuerySpec ==
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/_all_docs?include_docs=true
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test/_all_docs?include_docs=true
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/_design/test/_view/all_students
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/_design/test/_view/students_by_age?startkey=11
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/_design/test/_view/students_by_age?endkey=12
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/_design/test/_view/students_by_age?key=11
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/_design/test/_view/students_by_age?startkey=12&limit=2
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/_design/test/_view/students_by_age?descending=true&startkey=11
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/_design/test/_view/students_by_age_and_name?startkey=%5B11%5D&endkey=%5B12%2C%7B%7D%5D
	[info] + Queries should
	[info]   + work with all documents
	[info]   + support multi-document fetch
	[info]   + work with views
	[info]   + support minimum key bounds
	[info]   + support maximum key bounds
	[info]   + support key lookup
	[info]   + support limiting the number of results
	[info]   + support descending sort
	[info]   + preserve query ordering
	[info] == lift-couchdb / net.liftweb.couchdb.CouchQuerySpec ==
	[info]
	[info] == lift-couchdb / net.liftweb.couchdb.JsonRecordSpec ==
	[info] + A JSON record should
	[info]   + encode basic records correctly
	[info]   + encode record with subrecord correctly
	[info]   + decode basic records correctly
	[info]   + preserve extra fields from JSON
	[info]   + support unset optional fields
	[info]   + support set optional fields
	[info]   + support set subRecord field
	[info]   + not set missing fields
	[info]   + honor overrideIgnoreExtraJSONFields == true
	[info]   + honor overrideIgnoreExtraJSONFields == false
	[info]   + honor overrideNeedAllJSONFields == true
	[info]   + honor overrideNeedAllJSONFields == false
	[info] == lift-couchdb / net.liftweb.couchdb.JsonRecordSpec ==
	[info]
	[info] == lift-couchdb / net.liftweb.couchdb.CouchDocumentSpec ==
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/testdoc
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/969915a67b93a57eccfbb0d9f0030d57
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/969915a67b93a57eccfbb0d9f0031d23
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/969915a67b93a57eccfbb0d9f0031d23?rev=1-4cf33f8f525cc335684f957457867465
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/969915a67b93a57eccfbb0d9f0031d23?rev=2-db0d3ff1cbc642099bff5aca861db0d7
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/969915a67b93a57eccfbb0d9f0031d23
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test/969915a67b93a57eccfbb0d9f0032c13?rev=1-4cf33f8f525cc335684f957457867465
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/969915a67b93a57eccfbb0d9f0032c13
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test/969915a67b93a57eccfbb0d9f0033a22?rev=1-4cf33f8f525cc335684f957457867465
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test/969915a67b93a57eccfbb0d9f0033a22?rev=1-4cf33f8f525cc335684f957457867465
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/test
	[info] + A document should
	[info]   + give 404 on get when nonexistant
	[info]   + be insertable
	[info]   + have history
	[info]   + be deletable
	[info]   + give 404 on delete when nonexistant
	[info]   + be force storable
	[info] == lift-couchdb / net.liftweb.couchdb.CouchDocumentSpec ==
	[info]
	[info] == lift-couchdb / net.liftweb.couchdb.CouchRecordSpec ==
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/testdoc
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/969915a67b93a57eccfbb0d9f0033f40
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/969915a67b93a57eccfbb0d9f0033f7e
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/969915a67b93a57eccfbb0d9f00344bf
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test/969915a67b93a57eccfbb0d9f00344bf?rev=1-6aaedcc1f76eeb9a0bd2f82ad7fa93d6
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/969915a67b93a57eccfbb0d9f00344bf
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test/969915a67b93a57eccfbb0d9f003506f?rev=1-6aaedcc1f76eeb9a0bd2f82ad7fa93d6
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test/969915a67b93a57eccfbb0d9f003506f?rev=1-6aaedcc1f76eeb9a0bd2f82ad7fa93d6
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test/_all_docs?include_docs=true
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/_design/test/_view/people_by_age?key=30
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/_design/test/_view/oldest?include_docs=true&reduce=false
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/_design/test/_view/people_by_age?include_docs=true
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test2
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test2
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test2
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test2/969915a67b93a57eccfbb0d9f00396e3
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/969915a67b93a57eccfbb0d9f00396e3
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test2
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test2
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test2
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test2
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test2
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test2/_all_docs?include_docs=true
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test/_all_docs?include_docs=true
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test2
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test2
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test2/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test2
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test2
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test2
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test2/_design/test/_view/people_by_age?key=30
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/_design/test/_view/people_by_age?key=30
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test/_design/test
	INF: [console logger] dispatch: DELETE http://127.0.0.1:5984/test2
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test2
	INF: [console logger] dispatch: PUT http://127.0.0.1:5984/test2/_design/test
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test2
	INF: [console logger] dispatch: POST http://127.0.0.1:5984/test2
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test2/_design/test/_view/oldest?include_docs=true&reduce=false
	INF: [console logger] dispatch: GET http://127.0.0.1:5984/test/_design/test/_view/oldest?include_docs=true&reduce=false
	[info] + A couch record should
	[info]   + give emtpy box on get when nonexistant
	[info]   + be insertable
	[info]   + generate the right JSON
	[info]   + be deletable
	[info]   + be fetchable in bulk
	[info]   + support queries
	[info]   + support queries returning documents
	[info]   + support queries returning documents for a non-reducing view
	[info]   + support multiple databases for fetching
	[info]   + support multiple databases for fetching in bulk
	[info]   + support multiple databases for queries
	[info]   + support multiple databases for queries returning documents
	[info] == lift-couchdb / net.liftweb.couchdb.CouchRecordSpec ==
	[info]
	[info] == lift-couchdb / test-complete ==
	[info] == lift-couchdb / test-complete ==
	[info]
	[info] == lift-couchdb / Test cleanup 1 ==
	[info] Deleting directory /tmp/sbt_428d5f8c
	[info] == lift-couchdb / Test cleanup 1 ==
	[info]
	[info] == lift-couchdb / test-finish ==
	[info] Passed: : Total 51, Failed 0, Errors 0, Passed 51, Skipped 0
	[info]
	[info] All tests PASSED.
	[info] == lift-couchdb / test-finish ==
	[info]
	[info] == lift-couchdb / test-cleanup ==
	[info] == lift-couchdb / test-cleanup ==
	[info]
	[info] == lift-webkit / test-finish ==
	[info] Passed: : Total 140, Failed 0, Errors 0, Passed 136, Skipped 4
	[info]
	[info] All tests PASSED.
	[info] == lift-webkit / test-finish ==
	[info]
	[info] == lift-webkit / Test cleanup 1 ==
	[info] Deleting directory /tmp/sbt_79af926d
	[info] == lift-webkit / Test cleanup 1 ==
	[info]
	[info] == lift-webkit / test-cleanup ==
	[info] == lift-webkit / test-cleanup ==
	[info]
	[info] == lift-couchdb / test ==
	[info] == lift-couchdb / test ==
	[success] Successful.
	[info]
	[info] Total time: 90 s, completed Nov 3, 2011 4:55:42 PM
	[info]
	[info] Total session time: 91 s, completed Nov 3, 2011 4:55:42 PM
	[success] Build completed successfully.
	2011-11-03 16:55:42,940 [Shutdown] INFO org.mortbay.log - Shutdown hook executing
	2011-11-03 16:55:42,940 [Shutdown] INFO org.mortbay.log - Shutdown hook complete
	2011-11-03 16:55:43,940 [Shutdown] INFO org.mortbay.log - Shutdown hook complete


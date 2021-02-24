@ECHO OFF
C:
CD "\Users\abdcg\eclipse-workspace\SOEN341_ProjectB\src"
"C:\Program Files\Java\jdk-13.0.2\bin\javac.exe" TestNode.java
"C:\Program Files\Java\jdk-13.0.2\bin\javac.exe" TestAssemblyUnit.java
"C:\Program Files\Java\jdk-13.0.2\bin\javac.exe" TestErrorMessage.java
"C:\Program Files\Java\jdk-13.0.2\bin\javac.exe" TestErrorReporter.java
"C:\Program Files\Java\jdk-13.0.2\bin\javac.exe" TestPosition.java
"C:\Program Files\Java\jdk-13.0.2\bin\javac.exe" TestLinestatement.java
"C:\Program Files\Java\jdk-13.0.2\bin\javac.exe" TestInstruction.java
"C:\Program Files\Java\jdk-13.0.2\bin\javac.exe" TestToken1.java
"C:\Program Files\Java\jdk-13.0.2\bin\javac.exe" TestSourceFile.java
"C:\Program Files\Java\jdk-13.0.2\bin\javac.exe" TestOperand.java
"C:\Program Files\Java\jdk-13.0.2\bin\javac.exe" TestMnemonic.java
"C:\Program Files\Java\jdk-13.0.2\bin\javac.exe" TestLexer.java
"C:\Program Files\Java\jdk-13.0.2\bin\javac.exe" TestSymbolTable.java
"C:\Program Files\Java\jdk-13.0.2\bin\javac.exe" BinaryConverter_Test.java
rem pause
"C:\Program Files\Java\jdk-13.0.2\bin\java.exe"  TestNode       >  Tests.txt
"C:\Program Files\Java\jdk-13.0.2\bin\java.exe" TestAssemblyUnit	>>Tests.txt
"C:\Program Files\Java\jdk-13.0.2\bin\java.exe" TestErrorMessage	>>Tests.txt
"C:\Program Files\Java\jdk-13.0.2\bin\java.exe" TestErrorReporter	>>Tests.txt
"C:\Program Files\Java\jdk-13.0.2\bin\java.exe" TestPosition	>>Tests.txt
"C:\Program Files\Java\jdk-13.0.2\bin\java.exe" TestLinestatement	>>Tests.txt
"C:\Program Files\Java\jdk-13.0.2\bin\java.exe" TestInstruction	>>Tests.txt
"C:\Program Files\Java\jdk-13.0.2\bin\java.exe" TestToken1 >>Tests.txt
"C:\Program Files\Java\jdk-13.0.2\bin\java.exe" TestSourceFile	>>Tests.txt
"C:\Program Files\Java\jdk-13.0.2\bin\java.exe" TestOperand	>>Tests.txt
"C:\Program Files\Java\jdk-13.0.2\bin\java.exe" TestMnemonic	>>Tests.txt
"C:\Program Files\Java\jdk-13.0.2\bin\java.exe" TestLexer	>>Tests.txt
"C:\Program Files\Java\jdk-13.0.2\bin\java.exe" TestSymbolTable	>>Tests.txt
"C:\Program Files\Java\jdk-13.0.2\bin\java.exe" BinaryConverter_Test >>Tests.txt
type Tests.txt
"C:\Program Files\Java\jdk-13.0.2\bin\java.exe"  aunit     Tests.txt
pause
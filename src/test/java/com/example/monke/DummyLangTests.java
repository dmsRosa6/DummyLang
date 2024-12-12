package com.example.monke;

import com.dummylang.DummyInterpreter;
import org.junit.Test;
import static org.junit.Assert.*;

public class DummyLangTests {

    @Test
    public void testVariableDeclarationWithoutInitialization() {
        String input = "var a;;";
        String expected = "nil";
        assertEquals(expected, DummyInterpreter.interpret(input));
    }

    @Test
    public void testVariableDeclarationWithInitialization() {
        String input = "var a := 10;;";
        String expected = "10";
        assertEquals(expected, DummyInterpreter.interpret(input));
    }

    @Test
    public void testConstantDeclaration() {
        String input = "const b := 20;;";
        String expected = "20";
        assertEquals(expected, DummyInterpreter.interpret(input));
    }

    @Test
    public void testPointerDeclarationWithAddress() {
        String input = "var #p := 1.1;!p;;";
        String expected = "1.1";
        assertEquals(expected, DummyInterpreter.interpret(input));
    }

    @Test
    public void testPointerDeclarationWithoutInitialization() {
        String input = "var #p;;";
        String expected = "Returns the VCell, this can change so this will always fail";
        assertEquals(expected, DummyInterpreter.interpret(input));
    }

    @Test
    public void testPointerInitializationWithAddress() {
        String input = "var #a :=1; var #p := !a;;";
        String expected = "1";
        assertEquals(expected, DummyInterpreter.interpret(input));
    }

    @Test
    public void testWhileLoopWithDecrementAndPrint() {
        String input = "{var #x := 10;while !x>0 {x:=!x-1;println (!x) }};;";
        String expected = "false";
        assertEquals(expected, DummyInterpreter.interpret(input));
    }

    @Test
    public void testCreateVarWithReturnOfBlock(){
        String input = "var a := {var #x := 10;while !x>0 {x:=!x-1;x};!x};a;;";
        String expected = "0";
        assertEquals(expected, DummyInterpreter.interpret(input));
    }

    @Test
    public void testFunctionCallWithArguments() {
        String input = "{var x := 3;var y := 2 ; fn f(n,j){var a := 2+n;n*(j+a)};println (f(x,y))};;";
        String expected = "No Output";
        assertEquals(expected, DummyInterpreter.interpret(input));
    }

    @Test
    public void testRecursiveFunctionsFibonacciAndFactorial() {
        String input = "{var x := 6;fn fibonacci(n){if n==1 {1}{if n==2 {1}{fibonacci(n-1)+fibonacci(n-2)}}}; fibonacci(x)};;";
        String expected = "8";
        assertEquals(expected, DummyInterpreter.interpret(input));
    }
}

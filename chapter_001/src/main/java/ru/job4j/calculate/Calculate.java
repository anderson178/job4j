package ru.job4j.calculate;
	/**
	 *clas Calculate
	 *@author Denis Mironenko
	 *@since 29.07.2018
	 *@version 1.0
	*/
public class Calculate{	
	/**
	*основной метод выводящий текст "hello word" 
	*/
	public static void main (String[] args ){
			System.out.println("Hello word");
		}
	/**
	* Method echo.
	* @param name Your name.
	* @return Echo plus your name.
	*/
	public String echo(String name) {
    return "Echo, echo, echo : " + name;
	}
}
package com.zliang.snackbar.core.homework.school;

import com.zliang.snackbar.core.homework.school.man.Classmaster;
import com.zliang.snackbar.core.homework.school.man.Person;
import com.zliang.snackbar.core.homework.school.man.Student;
import com.zliang.snackbar.core.homework.school.man.Teacher;

public class SchoolTest {
	public static void main(String[] args) {
		School s = new School();
		s.built();
		
		Person p1 = new Person();
		Person p2 = new Teacher();
		Person p3 = new Student();
		Person p4 = new Classmaster();
		p1.eat("egg");
		p2.eat("rice");
		p3.eat("cake");
		p4.eat("apple");
		
	}
}

package com.pcm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentMarksController
{
	@GetMapping("/student-marks-card-json")
	@ResponseBody
	public StudentMarks displayMarks(@RequestParam(name="physics", required=false, defaultValue="0") float physics, @RequestParam(name="chemistry", required=false, defaultValue="0") float chemistry, @RequestParam(name="maths", required=false, defaultValue="0") float maths)
	{
		StudentMarks marks = new StudentMarks();
		marks.setPhysics(physics);
		marks.setChemistry(chemistry);
		marks.setMaths(maths);
		
        marks.setTotal(marks.getPhysics() + marks.getChemistry() + marks.getMaths());
		
		marks.setAverage(marks.getTotal() / 3);
		
		if(marks.getAverage()>=80)
		{
			marks.setGrade('A');
		}
		else if(marks.getAverage()>=50)
		{
			marks.setGrade('B');
		}
		else
		{
			marks.setGrade('C');
		}
		
		marks.getPhysics();
		marks.getChemistry();
		marks.getMaths();
		marks.getTotal();
		marks.getGrade();
		
		
		return marks;
	}
	
	@GetMapping("/student-marks-card-html")
	public ModelAndView htmlView (Model model, @RequestParam(required=false, defaultValue="0") float physics, @RequestParam(required=false, defaultValue="0") float chemistry, @RequestParam(required=false, defaultValue="0") float maths)
	{
		StudentMarks marks = new StudentMarks();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("marks", marks);
		mav.setViewName("marksinput.html");
		return mav;
	}
	
	@GetMapping("/marks-output-html")
	public ModelAndView htmlProcess(Model model, @RequestParam(required=false) float physics, @RequestParam(required=false) float chemistry, @RequestParam(required=false) float maths)
	{
		StudentMarks marks = new StudentMarks();
		
		
		marks.setPhysics(physics);
		marks.setChemistry(chemistry);
		marks.setMaths(maths);
		
		marks.setTotal(marks.getPhysics() + marks.getChemistry() + marks.getMaths());
		
		marks.setAverage(marks.getTotal() / 3);
		
		if(marks.getAverage()>=80)
		{
			marks.setGrade('A');
		}
		else if(marks.getAverage()>=50)
		{
			marks.setGrade('B');
		}
		else
		{
			marks.setGrade('C');
		}
		
		marks.getPhysics();
		marks.getChemistry();
		marks.getMaths();
		marks.getTotal();
		marks.getGrade();
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("marks", marks);
		mav.setViewName("mymarks.html");
		
		return mav;
	}
	
}
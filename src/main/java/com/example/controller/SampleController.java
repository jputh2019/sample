package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping("/sample")
public class SampleController {

	@RequestMapping(value="/delete/{first}/{second}/", method=RequestMethod.GET)
	@ResponseBody
	public List<Integer> getList(@PathVariable Integer first, @PathVariable Integer second ){
		List<Integer> aoFirst = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));		
		List<Integer> aoSecond = new ArrayList<Integer>(Arrays.asList(1, 2, 3));				
		return aoFirst.stream().filter(e -> (e != first && e != second )).distinct().collect(Collectors.toList());		
	}
	
	@RequestMapping(value="/sort/", method=RequestMethod.GET)
	@ResponseBody
	public List<Integer> getSortList(){
		List<Integer> aoFirst = new ArrayList<Integer>(Arrays.asList(1, 5, 6, 2, 3, 4));		
		List<Integer> aoSecond = new ArrayList<Integer>(Arrays.asList(1, 7, 3,2));				
		return Arrays.asList(aoFirst,aoSecond).stream().flatMap(list -> list.stream()).distinct().sorted().collect(Collectors.toList());
	}
	
}

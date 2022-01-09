/**
* 	@author SHAJIND C
*/

package com.example.defect.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.defect.model.DefectModel;
import com.example.defect.model.ResponseModel;
import com.example.defect.service.DefectService;

@RestController
public class DefectController {

	@Autowired
	private DefectService defectService;

	/**
	 * Method to create a new defect
	 *
	 * 
	 * @param Defect object
	 * @return The ID of the newly created Defect.
	 */

	@PostMapping("/add")
	public ResponseEntity<?> addDefect(@RequestBody DefectModel defect) {
		return ResponseEntity.ok(new ResponseModel(defectService.addDefect(defect)));
	}

	/**
	 * Method to update defect parameters using their ID
	 *
	 * 
	 * @param DefectModelHolder Object,Defect ID(String)
	 * @return A string of acknowledgement
	 */
	
	  @PutMapping("/update/{id}") 
	  public ResponseEntity<?> updateDefect(@RequestBody Map<String,String> defectModelHolder, @PathVariable String id) { 
		  return ResponseEntity.ok(new ResponseModel(defectService.updateDefect(defectModelHolder, id))); 
		  }
	 

	/**
	 * Method to get defects of project ID
	 *
	 * 
	 * @param Project ID(String)
	 * @return List of DefectModel Object
	 */
	@GetMapping("/getdetails/{projectID}")
	public List<DefectModel> getProjectDefect(@PathVariable String projectID) {
		return defectService.getProjectDefect(projectID);
	}

	/**
	 * Method to retrieve all the defects
	 *
	 * 
	 * 
	 * @return A list of all the defects in the collection
	 */
	@GetMapping("/getall")
	public List<DefectModel> getAlldefects() {
		return defectService.getAlldefects();
	}

	/**
	 * Method to retrieve details of Defect
	 *
	 * 
	 * @param ID(String)
	 * @return List of DefectModel Object
	 */
	@GetMapping("/getid/{id}")
	public DefectModel getDefect(@PathVariable String id) {
		return defectService.getDefect(id);
	}

	/**
	 * Method to delete details of Defect
	 *
	 * 
	 * @param ID(String)
	 * @return A string of acknowledgement
	 */
	@DeleteMapping("/deleteid/{id}")
	public ResponseEntity<?> deleteDefect(@PathVariable String id) {
		return ResponseEntity.ok(new ResponseModel(defectService.deleteDefect(id)));
	} 

}

package com.recrutmentmanagement.login;

import java.util.List;
import java.util.Queue;

import com.recrutmentmanagement.dto.Admin;
import com.recrutmentmanagement.dto.Candidate;
import com.recrutmentmanagement.dto.Hr;
import com.recrutmentmanagement.dto.Post;

import repository.RecrutmentDb;

public class LoginModel {

	public LoginModel() {
	}

	public boolean checkForAdmin(String name, String pass) {
		if (RecrutmentDb.getInstance().getAdmin().getName().equalsIgnoreCase(name.trim())
				&& RecrutmentDb.getInstance().getAdmin().getPassword().equalsIgnoreCase(pass.trim())) {
			return true;
		} else {
			return false;
		}
	}

	public List<Post> getPostHistory() {
		return RecrutmentDb.getInstance().getPost();
	}

	public Admin getAdmin() {
		return RecrutmentDb.getInstance().getAdmin();
	}

	public void changeAdminDetails(String name, String pass, long phno) {

		Admin admin = getAdmin();

		if (name != null) {
			admin.setName(name);
		} else if (pass != null) {
			admin.setPassword(pass);
		} else {
			admin.setMobileNumber(phno);
		}
	}

	public Candidate registerCandidate(String name, String pass) {

		Candidate candidate = new Candidate(name, pass);

		if (RecrutmentDb.getInstance().containsCandidate(name, pass)) {
			candidate = null;
		} else {
			RecrutmentDb.getInstance().getCandidates().add(candidate);

			RecrutmentDb.getInstance().getAdmin().getNotification().offer(name + " has created new Candidate Account ");

			candidate.getNotification().offer("Thanks for Creating Account " + name);
		}
		return candidate;

	}

	public Hr registerHr(String name, String pass, String organization) {

		Hr hr = new Hr(name, pass, organization);

		if (RecrutmentDb.getInstance().containsHr(name, pass)) {
			hr = null;
		} else {
			RecrutmentDb.getInstance().getHrlist().add(hr);

			RecrutmentDb.getInstance().getAdmin().getNotification().offer(name + " has created new Hr Account ");

			hr.getNotification().offer("Thanks for Creating Account " + name);
		}

		return hr;
	}

	public Hr hrLoginCredential(String name, String pass) {
		Hr hr = null;

		if (RecrutmentDb.getInstance().containsHr(name, pass))
			hr = RecrutmentDb.getInstance().getValidHr(name, pass);

		return hr;
	}

	public Candidate userLoignCredential(String name, String pass) {
		Candidate candidate = null;

		if (RecrutmentDb.getInstance().containsCandidate(name, pass))
			candidate = RecrutmentDb.getInstance().getValidCandidate(name, pass);

		return candidate;
	}

	public Queue<String> getNotification() {
		return getAdmin().getNotification();
	}
}

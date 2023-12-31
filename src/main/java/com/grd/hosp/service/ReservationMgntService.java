package com.grd.hosp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grd.hosp.controller.HospitalMemberMgntController;
import com.grd.hosp.dao.ReservationMapper;
import com.grd.hosp.dto.ReservationInqInpDto;
import com.grd.hosp.dto.ReservationInqPrnReptSbDto;
import com.grd.hosp.dto.ReservationRegInpDto;
import com.grd.hosp.entity.ReservationEntity;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReservationMgntService {

	@Autowired
	ReservationMapper reservationMapper; 
	
	public List<ReservationInqPrnReptSbDto> retreiveReservation(ReservationInqInpDto input) throws Exception{
		List<ReservationInqPrnReptSbDto> output = new ArrayList<ReservationInqPrnReptSbDto>();
		
		try {
			output = reservationMapper.retreiveReservation(input);
		}catch(Exception e) {
			return output;
		}
		
		return output;
	}
	
	public boolean registReservation(ReservationRegInpDto input) throws Exception{
		boolean output = false;
		int result = 0;
		
		try {
			result = reservationMapper.retreiveReservationDate(input);
			
			if(result > 0) {
				return false;
			}
			
			output = reservationMapper.registReservation(input);
		}catch(Exception e) {
			return output;
		}
		return output;
	}
	
	public boolean updateReservation(ReservationEntity reservationValue) throws Exception{
		boolean output = false;
		
		try {
			log.info(reservationValue.toString());
			output = reservationMapper.updateReservation(reservationValue);
		}catch(Exception e) {
			return output;
		}
		return output;
	}
}

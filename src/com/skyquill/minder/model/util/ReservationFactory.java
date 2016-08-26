//package com.skyquill.minder.model.util;
//
//import java.util.Date;
//
////import com.skyquill.minder.client.common.UserSession;
//import com.skyquill.minder.model.Audit;
//import com.skyquill.minder.model.FlightDeparture;
//import com.skyquill.minder.model.FlightReservation;
//import com.skyquill.minder.model.FlightRoute;
//import com.skyquill.minder.model.HotelReservation;
//import com.skyquill.minder.model.OtherReservation;
//import com.skyquill.minder.model.Reservation;
//import com.skyquill.minder.model.VehicleReservation;
//
//public class ReservationFactory {
//
//	private static ReservationFactory _instance;
//	
//	public static ReservationFactory getInstance() {
//		if (_instance==null)
//			_instance = new ReservationFactory();
//		
//		return _instance;
//	}
//	
//
//	private ReservationFactory() {
//	}
//	
//	public Reservation createReservation(String type) {
//		return createReservation(type, new Date(), null, null, null);
//	}
//	public Reservation createReservation(String type, Date resvDate, Long airportId, Long cityId, String purpose) {
//
//		Reservation resv = null;
//
//		if (type == Reservation.FLIGHT_TYPE) {
//			FlightReservation fr = new FlightReservation();
//			FlightDeparture fd = new FlightDeparture();
//			FlightRoute frt = new FlightRoute();
//			if (resvDate!=null) {
//				fd.setDepartureDate(resvDate);
//				fd.setArrivalDate(resvDate);
//			}
//			frt.addFlightDeparture(fd);
//			if (airportId!=null) {
//				frt.setOriginAirportId(airportId);
//				frt.setDestAirportId(airportId);
//			}
//			fr.setPurpose(purpose);
//			fd.addFlightReservation(fr);
//			fr.setNeedsFollowUp(false);
//			resv = fr;
//			
//		} else if (type == Reservation.HOTEL_TYPE) {
//			HotelReservation hr = new HotelReservation();
//			if (resvDate!=null) {
//				hr.setArrivalDate(resvDate);
//				hr.setCheckoutDate(resvDate);
//			}
//			if (cityId!=null) {
//				hr.setCityId(cityId);
//			}
//			hr.setPurpose(purpose);
//			hr.setNeedsFollowUp(false);
//			resv = hr;
//			
//		} else if (type == Reservation.VEHICLE_TYPE) {
//			VehicleReservation vr = new VehicleReservation();
//			if (resvDate!=null) {
//				vr.setStartDate(resvDate);
//				vr.setEndDate(resvDate);
//			}
//			if (cityId!=null) {
//				vr.setCityId(cityId);
//			}
//			vr.setPurpose(purpose);
//			vr.setNeedsFollowUp(false);
//			resv = vr;
//			
//		} else if (type == Reservation.OTHER_TYPE) {
//			OtherReservation or = new OtherReservation();
//			if (resvDate!=null) {
//				or.setResvDate(resvDate);
//			}
//			if (cityId!=null) {
//				or.setCityId(cityId);
//			}
//			or.setPurpose(purpose);
//			or.setNeedsFollowUp(false);
//			resv = or;
//			
//		}
//		
//		resv.setNew(true);
////		Audit audit = new Audit(UserSession.getInstance().getUsername());
//		Audit audit = new Audit();
//		resv.setAudit(audit);
//		
//		return resv;
//	}
//
//	public Reservation cloneReservation(Reservation resv, long adjTime, Audit audit) {
//
//		Reservation newResv = null;
//
//		String type = resv.getResType();
//		
//		if (type.equals(Reservation.FLIGHT_TYPE)) {
//			FlightReservation fres = (FlightReservation)resv;
//			newResv = fres.clone(adjTime, audit);
//			System.out.println("cloneReservation: cloned fres");
//		} else if (type.equals(Reservation.HOTEL_TYPE)) {
//			HotelReservation hr = (HotelReservation)resv;
//			newResv = hr.clone(adjTime);
//			System.out.println("cloneReservation: cloned hr");
//		} else if (type.equals(Reservation.VEHICLE_TYPE)) {
//			VehicleReservation vr = (VehicleReservation)resv;
//			newResv = vr.clone(adjTime);
//			System.out.println("cloneReservation: cloned vr");
//		} else if (type.equals(Reservation.OTHER_TYPE)) {
//			OtherReservation or = (OtherReservation)resv;
//			newResv = or.clone(adjTime);
//			System.out.println("cloneReservation: cloned or");
//		} else {
//			System.out.println("cloneReservation: type unknown!");
//			System.out.println("cloneReservation: type unknown: " + type);
//		}
//		
//		newResv.setNew(true);
//		newResv.setAudit(audit);
//		
//		return newResv;
//	}
//	
//}

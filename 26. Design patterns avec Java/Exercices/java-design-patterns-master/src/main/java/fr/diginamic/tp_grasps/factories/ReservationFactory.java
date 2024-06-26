package fr.diginamic.tp_grasps.factories;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import fr.diginamic.tp_grasps.beans.Client;
import fr.diginamic.tp_grasps.beans.Reservation;
import fr.diginamic.tp_grasps.beans.TypeReservation;

public class ReservationFactory {
    /** formatter */
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Reservation create(String dateString, Client client, int numberPlaces, TypeReservation type){
        LocalDateTime date = LocalDateTime.parse(dateString, formatter);
        Reservation reservation = new Reservation(date);
        reservation.setClient(client);
        reservation.setNbPlaces(numberPlaces);

        // 6) Ajout de la réservation au client
        client.getReservations().add(reservation);

        // 7) Calcul du montant total de la réservation qui dépend:
		//    - du nombre de places
		//    - de la réduction qui s'applique si le client est premium ou non
        double total = type.getMontant() * numberPlaces;
		if (client.isPremium()) {
			reservation.setTotal(total*(1-type.getReductionPourcent()/100.0));
		}
		else {
			reservation.setTotal(total);
		}

        return reservation;
    }
}

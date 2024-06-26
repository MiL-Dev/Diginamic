package fr.diginamic.tp_grasps;

import fr.diginamic.tp_grasps.beans.Client;
import fr.diginamic.tp_grasps.beans.Reservation;
import fr.diginamic.tp_grasps.beans.TypeReservation;
import fr.diginamic.tp_grasps.daos.ClientDao;
import fr.diginamic.tp_grasps.daos.TypeReservationDao;
import fr.diginamic.tp_grasps.factories.ReservationFactory;

/** Controlleur qui prend en charge la gestion des réservations client
 * @author RichardBONNAMY
 *
 */
public class ReservationController {
	
	/** DAO permettant d'accéder à la table des clients */
	private ClientDao clientDao = new ClientDao();
	
	/** DAO permettant d'accéder à la table des types de réservation */
	private TypeReservationDao typeReservationDao = new TypeReservationDao();

	/**
	 * Factory permettant de créer des réservations
	 */
	private ReservationFactory reservationFactory = new ReservationFactory();
	
	/** Méthode qui créée une réservation pour un client à partir des informations transmises
	 * @param params contient toutes les infos permettant de créer une réservation
	 * @return Reservation
	 */
	public Reservation creerReservation(Params params) {
		String identifiantClient = params.getIdentifiantClient();
		String dateReservationStr = params.getDateReservation();
		String typeReservation = params.getTypeReservation();
		int nbPlaces = params.getNbPlaces();
		
		Client client = clientDao.extraireClient(identifiantClient);
		TypeReservation type = typeReservationDao.extraireTypeReservation(typeReservation);
		
		return reservationFactory.create(dateReservationStr, client, nbPlaces, type);
	}
}

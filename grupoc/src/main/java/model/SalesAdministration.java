package model;

import org.joda.time.DateTime;
import org.joda.time.Days;

import exception.BalanceInsufficient;
import exception.InvalidPurchaseException;
import exception.PendingScoreException;

public class SalesAdministration {
	ScoringManager scoringManager;
	
	public SalesAdministration(ScoringManager scoringManager){
		this.scoringManager=scoringManager;
		
	}
	
     public void saleMenu(Menu menu, Client client, Provider provider) throws PendingScoreException, BalanceInsufficient, InvalidPurchaseException{
    	 if(scoringManager.hasPendingScoreForClient(client)){
    		 throw new PendingScoreException("Tiene calificaciones pendientes a completar");
    	 }
    	 manageSales(menu,client,provider);
    	 
     }

	private void manageSales(Menu menu, Client client, Provider provider) throws BalanceInsufficient, InvalidPurchaseException {
		Double clientBalance= client.getAccount().balance();
		if(!isHasBalanceToBuy(clientBalance,menu.getMenuPrice())){
			throw new BalanceInsufficient("No tiene dinero suficiente para realizar la compra");
		}
		forSale(menu,client,provider);
	}

	private void forSale(Menu menu, Client client, Provider provider) throws InvalidPurchaseException, BalanceInsufficient {
		    if(!isTheSaleOfTheMenuWithinTheLimitOfPurchase(menu)){
		    	throw new InvalidPurchaseException("La compra del menu esta fuera del limite de venta");
		    }
		    finishSale(menu,client,provider);
		
	}

	private void finishSale(Menu menu, Client client, Provider provider) throws BalanceInsufficient {
		createNewScoreOfClient(provider,client,menu);
		chargeClientMenu(menu,client);		
	}

	private void chargeClientMenu(Menu menu, Client client) throws BalanceInsufficient {
		Transaction newTransaction= new Transaction(TypeTransaction.DEBIT, menu.getMenuPrice());
		client.getAccount().addTransaction(newTransaction);
		
	}

	private void createNewScoreOfClient(Provider provider,Client client, Menu menu) {
		Score newScore= new Score(provider, client, menu);
		this.scoringManager.addScore(newScore);
		
	}

	private boolean isTheSaleOfTheMenuWithinTheLimitOfPurchase(Menu menu){
	   DateTime purchasDayMade= new DateTime();
       Integer days= Days.daysBetween(purchasDayMade.toLocalDate(),menu.getEndDateOfferMenu().toLocalDate()).getDays();
		return days>=2;
	}

	private boolean isHasBalanceToBuy(Double clientBalance, Double menuPrice) {
	
		return clientBalance>=menuPrice;
	}

}

package com.luxoft.bankapp.model;

import java.util.*;

import com.luxoft.bankapp.service.Report;

public class Bank implements Report{
	
	private Set<Client> clients;
	private List<ClientRegistrationListener> listeners;
	
	public Bank() {
		clients =  new TreeSet<Client>(new Comparator<Client>() {
			@Override
			public int compare(Client c1, Client c2) {
				return c1.getCity().compareTo(c2.getCity());
			}
		});
		listeners = new ArrayList<ClientRegistrationListener>();
		listeners.add(new PrintClientListener());
		listeners.add(new EmailNotificationListener());
		/*listeners.add(new ClientRegistrationListener(){ //using the anonymous classes
			@Override
			public void onClientAdded(Client client) {
				client.printReport();
				
			}
		});
		listeners.add(new ClientRegistrationListener(){
			@Override
			public void onClientAdded(Client client) {
				System.out.println("Notification email for client " + client.getName() + " to be sent");	
			}
		});*/
	}
	
	public void addClient(Client client){
		clients.add(client);
		
		for(ClientRegistrationListener listener : listeners){
			listener.onClientAdded(client);
		}
	}
	
	public void removeClient(Client client){
		clients.remove(client);
	}
	
	public Set<Client> getClients() {
		return Collections.unmodifiableSet(clients);
	}

	@Override
	public void printReport() {
		System.out.println("Bank clients: ");
		for(Client c : clients){
			c.printReport();
		}
		
	}
	
	private class PrintClientListener implements ClientRegistrationListener{

		@Override
		public void onClientAdded(Client client) {
			client.printReport();
			
		}
		
	}
	
	private class EmailNotificationListener implements ClientRegistrationListener{

		@Override
		public void onClientAdded(Client client) {
			System.out.println("Notification email for client " + client.getName() + " to be sent");	
		}
		
	}

}

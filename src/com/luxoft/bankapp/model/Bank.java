package com.luxoft.bankapp.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.luxoft.bankapp.service.Report;

public class Bank implements Report{
	
	private List<Client> clients;
	private List<ClientRegistrationListener> listeners;
	
	public Bank() {
		clients = new LinkedList<Client>();
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
	
	public List<Client> getClients() {
		return Collections.unmodifiableList(clients);
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

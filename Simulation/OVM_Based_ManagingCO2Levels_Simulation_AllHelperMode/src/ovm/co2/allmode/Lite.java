/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovm.co2.allmode;

/**
 *
 * @author sy
 */
public class Lite extends Helper{

	public Lite(String name, Parameters p, double msgPayloadReadTime) {
		super(name, p, msgPayloadReadTime);
		this.msgPayloadReadtime = msgPayloadReadTime;
	}

}


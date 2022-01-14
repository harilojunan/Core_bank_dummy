//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.13 at 05:32:26 PM IST 
//


package com.trabeya.core_bank.accounts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="our_user_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="our_account_no" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="initial_account_balance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="final_account_balance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ourUserId",
    "ourAccountNo",
    "initialAccountBalance",
    "finalAccountBalance"
})
@XmlRootElement(name = "otherFundTransferResponse")
public class OtherFundTransferResponse {

    @XmlElement(name = "our_user_id", required = true)
    protected String ourUserId;
    @XmlElement(name = "our_account_no", required = true)
    protected String ourAccountNo;
    @XmlElement(name = "initial_account_balance")
    protected double initialAccountBalance;
    @XmlElement(name = "final_account_balance")
    protected double finalAccountBalance;

    /**
     * Gets the value of the ourUserId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOurUserId() {
        return ourUserId;
    }

    /**
     * Sets the value of the ourUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOurUserId(String value) {
        this.ourUserId = value;
    }

    /**
     * Gets the value of the ourAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOurAccountNo() {
        return ourAccountNo;
    }

    /**
     * Sets the value of the ourAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOurAccountNo(String value) {
        this.ourAccountNo = value;
    }

    /**
     * Gets the value of the initialAccountBalance property.
     * 
     */
    public double getInitialAccountBalance() {
        return initialAccountBalance;
    }

    /**
     * Sets the value of the initialAccountBalance property.
     * 
     */
    public void setInitialAccountBalance(double value) {
        this.initialAccountBalance = value;
    }

    /**
     * Gets the value of the finalAccountBalance property.
     * 
     */
    public double getFinalAccountBalance() {
        return finalAccountBalance;
    }

    /**
     * Sets the value of the finalAccountBalance property.
     * 
     */
    public void setFinalAccountBalance(double value) {
        this.finalAccountBalance = value;
    }

}

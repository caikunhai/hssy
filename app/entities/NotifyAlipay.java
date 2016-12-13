/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - name      : DomainEntityJPA2Annotation
	* - file name : DomainEntityJPA2Annotation.vm
	* - time      : 2016/10/20 ��Ԫ at 14:53:33 CST
*/
package entities;

import java.io.Serializable;
//MP-MANAGED-ADDED-AREA-BEGINNING @import@
//MP-MANAGED-ADDED-AREA-ENDING @import@
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * <p>Title: NotifyAlipay</p>
 *
 * <p>Description: Domain Object describing a NotifyAlipay entity</p>
 *
 */
@Entity (name="NotifyAlipay")
@Table (name="notify_alipay")
@NamedQueries({
	 @NamedQuery(name="NotifyAlipay.findAll", query="SELECT notifyalipay FROM NotifyAlipay notifyalipay")
	,@NamedQuery(name="NotifyAlipay.findByOutTradeNo", query="SELECT notifyalipay FROM NotifyAlipay notifyalipay WHERE notifyalipay.outTradeNo = :outTradeNo")
	,@NamedQuery(name="NotifyAlipay.findByOutTradeNoContaining", query="SELECT notifyalipay FROM NotifyAlipay notifyalipay WHERE notifyalipay.outTradeNo like :outTradeNo")

	,@NamedQuery(name="NotifyAlipay.findByTradeNo", query="SELECT notifyalipay FROM NotifyAlipay notifyalipay WHERE notifyalipay.tradeNo = :tradeNo")
	,@NamedQuery(name="NotifyAlipay.findByTradeNoContaining", query="SELECT notifyalipay FROM NotifyAlipay notifyalipay WHERE notifyalipay.tradeNo like :tradeNo")

	,@NamedQuery(name="NotifyAlipay.findByTradeStatus", query="SELECT notifyalipay FROM NotifyAlipay notifyalipay WHERE notifyalipay.tradeStatus = :tradeStatus")
	,@NamedQuery(name="NotifyAlipay.findByTradeStatusContaining", query="SELECT notifyalipay FROM NotifyAlipay notifyalipay WHERE notifyalipay.tradeStatus like :tradeStatus")

	,@NamedQuery(name="NotifyAlipay.findByBuyerEmail", query="SELECT notifyalipay FROM NotifyAlipay notifyalipay WHERE notifyalipay.buyerEmail = :buyerEmail")
	,@NamedQuery(name="NotifyAlipay.findByBuyerEmailContaining", query="SELECT notifyalipay FROM NotifyAlipay notifyalipay WHERE notifyalipay.buyerEmail like :buyerEmail")

	,@NamedQuery(name="NotifyAlipay.findByBuyerId", query="SELECT notifyalipay FROM NotifyAlipay notifyalipay WHERE notifyalipay.buyerId = :buyerId")
	,@NamedQuery(name="NotifyAlipay.findByBuyerIdContaining", query="SELECT notifyalipay FROM NotifyAlipay notifyalipay WHERE notifyalipay.buyerId like :buyerId")

	,@NamedQuery(name="NotifyAlipay.findByNotifyId", query="SELECT notifyalipay FROM NotifyAlipay notifyalipay WHERE notifyalipay.notifyId = :notifyId")
	,@NamedQuery(name="NotifyAlipay.findByNotifyIdContaining", query="SELECT notifyalipay FROM NotifyAlipay notifyalipay WHERE notifyalipay.notifyId like :notifyId")

	,@NamedQuery(name="NotifyAlipay.findByTotalFee", query="SELECT notifyalipay FROM NotifyAlipay notifyalipay WHERE notifyalipay.totalFee = :totalFee")
	,@NamedQuery(name="NotifyAlipay.findByTotalFeeContaining", query="SELECT notifyalipay FROM NotifyAlipay notifyalipay WHERE notifyalipay.totalFee like :totalFee")

	,@NamedQuery(name="NotifyAlipay.findByCreatedTime", query="SELECT notifyalipay FROM NotifyAlipay notifyalipay WHERE notifyalipay.createdTime = :createdTime")

})

public class NotifyAlipay implements Serializable {
    private static final long serialVersionUID = 1L;
	public static final String __DEFAULT_TRADE_STATUS = new String("0");

    public static final String FIND_ALL = "NotifyAlipay.findAll";
    public static final String FIND_BY_OUTTRADENO = "NotifyAlipay.findByOutTradeNo";
    public static final String FIND_BY_OUTTRADENO_CONTAINING ="NotifyAlipay.findByOutTradeNoContaining";
    public static final String FIND_BY_TRADENO = "NotifyAlipay.findByTradeNo";
    public static final String FIND_BY_TRADENO_CONTAINING ="NotifyAlipay.findByTradeNoContaining";
    public static final String FIND_BY_TRADESTATUS = "NotifyAlipay.findByTradeStatus";
    public static final String FIND_BY_TRADESTATUS_CONTAINING ="NotifyAlipay.findByTradeStatusContaining";
    public static final String FIND_BY_BUYEREMAIL = "NotifyAlipay.findByBuyerEmail";
    public static final String FIND_BY_BUYEREMAIL_CONTAINING ="NotifyAlipay.findByBuyerEmailContaining";
    public static final String FIND_BY_BUYERID = "NotifyAlipay.findByBuyerId";
    public static final String FIND_BY_BUYERID_CONTAINING ="NotifyAlipay.findByBuyerIdContaining";
    public static final String FIND_BY_NOTIFYID = "NotifyAlipay.findByNotifyId";
    public static final String FIND_BY_NOTIFYID_CONTAINING ="NotifyAlipay.findByNotifyIdContaining";
    public static final String FIND_BY_TOTALFEE = "NotifyAlipay.findByTotalFee";
    public static final String FIND_BY_TOTALFEE_CONTAINING ="NotifyAlipay.findByTotalFeeContaining";
    public static final String FIND_BY_CREATEDTIME = "NotifyAlipay.findByCreatedTime";
	
    @Id @Column(name="id" ) 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//MP-MANAGED-ADDED-AREA-BEGINNING @out_trade_no-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @out_trade_no-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-out_trade_no@
    @Column(name="out_trade_no"  , length=150 , nullable=true , unique=false)
    private String outTradeNo; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @trade_no-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @trade_no-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-trade_no@
    @Column(name="trade_no"  , length=50 , nullable=true , unique=false)
    private String tradeNo; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @trade_status-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @trade_status-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-trade_status@
    @Column(name="trade_status"  , length=30 , nullable=true , unique=false)
    private String tradeStatus; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @buyer_email-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @buyer_email-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-buyer_email@
    @Column(name="buyer_email"  , length=50 , nullable=true , unique=false)
    private String buyerEmail; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @buyer_id-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @buyer_id-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-buyer_id@
    @Column(name="buyer_id"  , length=50 , nullable=true , unique=false)
    private String buyerId; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @notify_id-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @notify_id-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-notify_id@
    @Column(name="notify_id"  , length=50 , nullable=true , unique=false)
    private String notifyId; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @total_fee-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @total_fee-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-total_fee@
    @Column(name="total_fee"  , length=50 , nullable=true , unique=false)
    private String totalFee; 
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @created_time-field-annotation@
//MP-MANAGED-ADDED-AREA-ENDING @created_time-field-annotation@
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @ATTRIBUTE-created_time@
    @Column(name="created_time"   , nullable=true , unique=false)
    private Timestamp createdTime; 
//MP-MANAGED-UPDATABLE-ENDING

    /**
    * Default constructor
    */
    public NotifyAlipay() {
    }

	/**
	* All field constructor 
	*/
    public NotifyAlipay(
       Long id,
       String outTradeNo,
       String tradeNo,
       String tradeStatus,
       String buyerEmail,
       String buyerId,
       String notifyId,
       String totalFee,
       Timestamp createdTime) {
       //primary keys
       setId (id);
       //attributes
       setOutTradeNo (outTradeNo);
       setTradeNo (tradeNo);
       setTradeStatus (tradeStatus);
       setBuyerEmail (buyerEmail);
       setBuyerId (buyerId);
       setNotifyId (notifyId);
       setTotalFee (totalFee);
       setCreatedTime (createdTime);
       //parents
    }

	public NotifyAlipay flat() {
	   return new NotifyAlipay(
          getId(),
          getOutTradeNo(),
          getTradeNo(),
          getTradeStatus(),
          getBuyerEmail(),
          getBuyerId(),
          getNotifyId(),
          getTotalFee(),
          getCreatedTime()
	   );
	}

    public Long getId() {
        return id;
    }
	
    public void setId (Long id) {
        this.id =  id;
    }
    
//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-out_trade_no@
    public String getOutTradeNo() {
        return outTradeNo;
    }
	
    public void setOutTradeNo (String outTradeNo) {
        this.outTradeNo =  outTradeNo;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-trade_no@
    public String getTradeNo() {
        return tradeNo;
    }
	
    public void setTradeNo (String tradeNo) {
        this.tradeNo =  tradeNo;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-trade_status@
    public String getTradeStatus() {
        return tradeStatus;
    }
	
    public void setTradeStatus (String tradeStatus) {
        this.tradeStatus =  tradeStatus;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-buyer_email@
    public String getBuyerEmail() {
        return buyerEmail;
    }
	
    public void setBuyerEmail (String buyerEmail) {
        this.buyerEmail =  buyerEmail;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-buyer_id@
    public String getBuyerId() {
        return buyerId;
    }
	
    public void setBuyerId (String buyerId) {
        this.buyerId =  buyerId;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-notify_id@
    public String getNotifyId() {
        return notifyId;
    }
	
    public void setNotifyId (String notifyId) {
        this.notifyId =  notifyId;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-total_fee@
    public String getTotalFee() {
        return totalFee;
    }
	
    public void setTotalFee (String totalFee) {
        this.totalFee =  totalFee;
    }
	
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @GETTER-SETTER-created_time@
    public Timestamp getCreatedTime() {
        return createdTime;
    }
	
    public void setCreatedTime (Timestamp createdTime) {
        this.createdTime =  createdTime;
    }
	
//MP-MANAGED-UPDATABLE-ENDING




//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @prepersist-notify_alipay@
    @javax.persistence.PrePersist
    public void prePersist_ () {
        if (tradeStatus==null) tradeStatus=__DEFAULT_TRADE_STATUS;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-UPDATABLE-BEGINNING-DISABLE @preupdate-notify_alipay@
    @javax.persistence.PreUpdate
    public void preUpdate_ () {
        if (tradeStatus==null) tradeStatus=__DEFAULT_TRADE_STATUS;
    }
//MP-MANAGED-UPDATABLE-ENDING

//MP-MANAGED-ADDED-AREA-BEGINNING @implementation@
//MP-MANAGED-ADDED-AREA-ENDING @implementation@

}

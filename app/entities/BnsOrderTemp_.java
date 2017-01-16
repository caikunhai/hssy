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
	* - name      : DomainEntityJPA2Metamodel
	* - file name : DomainEntityJPA2Metamodel.vm
	* - time      : 2017/01/14 ��Ԫ at 13:18:39 CST
*/
package entities;

import java.sql.Timestamp;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(BnsOrderTemp.class)
public class BnsOrderTemp_ {

    public static volatile SingularAttribute<BnsOrderTemp, String> id;

    public static volatile SingularAttribute<BnsOrderTemp, String> token;
    public static volatile SingularAttribute<BnsOrderTemp, String> company;
    public static volatile SingularAttribute<BnsOrderTemp, String> business;
    public static volatile SingularAttribute<BnsOrderTemp, String> site;
    public static volatile SingularAttribute<BnsOrderTemp, java.math.BigDecimal> siteMoney;
    public static volatile SingularAttribute<BnsOrderTemp, String> hotel;
    public static volatile SingularAttribute<BnsOrderTemp, java.math.BigDecimal> hotelMoney;
    public static volatile SingularAttribute<BnsOrderTemp, Timestamp> createdTime;




}

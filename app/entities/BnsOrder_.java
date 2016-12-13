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
	* - time      : 2016/11/13 ��Ԫ at 19:54:26 CST
*/
package entities;

import java.sql.Timestamp;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@StaticMetamodel(BnsOrder.class)
public class BnsOrder_ {

    public static volatile SingularAttribute<BnsOrder, String> id;

    public static volatile SingularAttribute<BnsOrder, String> code;
    public static volatile SingularAttribute<BnsOrder, String> city;
    public static volatile SingularAttribute<BnsOrder, Timestamp> takeTime;
    public static volatile SingularAttribute<BnsOrder, String> createdUser;
    public static volatile SingularAttribute<BnsOrder, String> customer;
    public static volatile SingularAttribute<BnsOrder, String> idcard;
    public static volatile SingularAttribute<BnsOrder, String> mobile;
    public static volatile SingularAttribute<BnsOrder, Integer> people;
    public static volatile SingularAttribute<BnsOrder, String> cloth;
    public static volatile SingularAttribute<BnsOrder, String> site;
    public static volatile SingularAttribute<BnsOrder, String> hotel;
    public static volatile SingularAttribute<BnsOrder, java.math.BigDecimal> money;
    public static volatile SingularAttribute<BnsOrder, String> payment;
    public static volatile SingularAttribute<BnsOrder, Integer> pickup;
    public static volatile SingularAttribute<BnsOrder, Integer> state;
    public static volatile SingularAttribute<BnsOrder, String> acceptUser;
    public static volatile SingularAttribute<BnsOrder, String> imgs;
    public static volatile SingularAttribute<BnsOrder, String> remark;
    public static volatile SingularAttribute<BnsOrder, Timestamp> createdTime;




}

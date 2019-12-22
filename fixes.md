FIXES

# xss_dashboard.php_10_min
TP
dashboard.php
`151 <?php while ($orderResult = mysqli_fetch_assoc($userwiseQuery)) { ?>`
`153 <td><?php echo $orderResult['username']?></td>`

FIX
`153 <td><?php echo (htmlentities($orderResult['username']))?></td> `

# xss_fetchBrand.php_1_min
`48 echo json_encode($output);`
`48 echo json_encode(htmlentities($output));`

`38 		htmlentities($row[1]),`

# xss_fetchCategories.php_1_min
`htmlentities($row[1]), 		`
`38 $row[1],`

# xss_fetchOrder.php_1_min
`55		// client name
 		$row[2], 
 		// client contact
 		$row[3], 	`
`55		// client name
 		htmlentities($row[2]), 
 		// client contact
 		htmlentities($row[3]), 	`


# xss_fetchProduct.php_1_min
`62  	// product name
 		htmlentities($row[1]), 
 		// rate
 		htmlentities($row[6]),
 		// quantity 
 		$row[5], 		 	
 		// brand
 		htmlentities($brand),
 		// category 		
 		htmlentities($category),`


# xss_fetchUser.php_1_min
`35 $output['data'][] = array( 		
 		// name
 		$username,
`

`35 $output['data'][] = array( 		
 		// name
 		htmlentities($username),
`


# xss_printOrder.php_1_min
`$clientName = $orderData[1];
$clientContact = $orderData[2];`

`$clientName = htmlentities($orderData[1]);
$clientContact = htmlentities($orderData[2]); `

`137                     <td style="border-left: 1px solid black;height: 27px;">'.htmlentities($row[4]).'</td`

# xss_getOrderReport.php_1_min
`
33				<td><center>'.htmlentities($result['client_name']).'</center></td>
34				<td><center>'.htmlentities($result['client_contact']).'</center></td>
				`
XSS vulnerabilities

http://localhost/phpmyadmin/
user: 'root'
password: ''

http://localhost/inventory-management-system/dashboard.php
username: 'admin'
password: 'admin'



----------------------------------
# xss_dashboard.php_3_min
FP becaue it looks only for the number of queries with mysqli_num_rows
dashboard.php
7  `$countProduct = mysqli_num_rows($query);`
75 `<span class="badge pull pull-right"><?php echo $countProduct; ?></span>`
FP because the $countProduct is not a variable modifiable by the user, it simply takes a static value from the db that changes only due to the number of products.

# xss_dashboard.php_4_min
FP same as before it is a number
dashboard.php
20 `$countLowStock = mysqli_num_rows($lowStockQuery);`
87 `<span class="badge pull pull-right"><?php echo $countLowStock; ?></span>`
same as before, it comes from a fixed sql statement so it cant be anything exceptional.

# xss_dashboard.php_5_min
FP same as before it is a number
dashboard.php
`11  $countOrder = mysqli_num_rows($orderQuery);`
`101 <span class="badge pull pull-right"><?php echo $countOrder; ?></span>`
same as before, it comes from a fixed sql statement so it cant be anything exceptional.
same as before

# xss_dashboard.php_11_min
FP same as before it is a number the results is always a number
dashboard.php
`151 <?php while ($orderResult = mysqli_fetch_assoc($userwiseQuery)) { ?>`
`154 <td><?php echo $orderResult['totalorder']?></td>`
same as before


# xss_dashboard.php_10_min
TP
dashboard.php
`151 <?php while ($orderResult = mysqli_fetch_assoc($userwiseQuery)) { ?>`
`153 <td><?php echo $orderResult['username']?></td>`

FIX
`153 <td><?php echo (htmlentities($orderResult['username']))?></td> `

sudo /opt/lampp/lampp restart
--------------------------------- DONE 1 TP OVER 5



------------------------
# xss_seeting.php_1_min
FP because it is echoed in a textBox, so it is not interpreted
setting.php
`$sql = "SELECT * FROM users WHERE user_id = {$user_id}";`
`7  $result = mysqli_fetch_assoc($query);`
`35 <input type="text" class="form-control" id="username" name="username" placeholder="Usename" value="<?php echo $result['username']; ?>"/>`

# xss_setting.php_2_min
FP because it is printed the user_id 
`7  $result = mysqli_fetch_assoc($query);`
`41 <input type="hidden" name="user_id" id="user_id" value="<?php echo $result['user_id'] ?>" />`

# xss_setting.php_3_min
FP because it is echoed in a textBox, so it is not interpreted
`7  $result = mysqli_fetch_assoc($query);`
`57 <input type="text" class="form-control" id="bio" name="bio" placeholder="Bio" value="<?php echo $result['bio']; ?>"/>`

# xss_setting.php_4_min
FP because it is printed the user_id 
`7  $result = mysqli_fetch_assoc($query);`
`63 <input type="hidden" name="user_id" id="user_id" value="<?php echo $result['user_id'] ?>" />`

# xss_setting.php_5_min
FP because it is printed the user_id 
`7  $result = mysqli_fetch_assoc($query);`
`99 <input type="hidden" name="user_id" id="user_id" value="<?php echo $result['user_id'] ?>" />`
--------------------------------- DONE 0 TP OVER 5

# xss_index.php_2_min
FP it just print the address of the server to consent form to work, the var printed is `$_SERVER[PHP_SELF]` which can be modified only by the server.

# xss_ssp.php_1_min
FP print an encoded json, there is no way that it will be interpreted as html.

--------------------- done 0 tp over 2




-------
# xss_product.php_1_min
brandName
`108 echo "<option value='".$row[0]."'>".$row[1]."</option>";`
$sql = "SELECT brand_id, brand_name, brand_active, brand_status FROM brands WHERE brand_status = 1 AND brand_active = 1";

# xss_product.php_2_min
categoryName
`127 echo "<option value='".$row[0]."'>".$row[1]."</option>";`
$sql = "SELECT categories_id, categories_name, categories_active, categories_status FROM categories WHERE categories_status = 1 AND categories_active = 1

# xss_product.php_3_min
editBrandName
`266 echo "<option value='".$row[0]."'>".$row[1]."</option>";`
$sql = "SELECT brand_id, brand_name, brand_active, brand_status FROM brands WHERE brand_status = 1 AND brand_active = 1"

# xss_product.php_4_min
editCategoryName
`285 echo "<option value='".$row[0]."'>".$row[1]."</option>";`
$sql = "SELECT categories_id, categories_name, categories_active, categories_status FROM categories WHERE categories_status = 1 AND categories_active = 1";

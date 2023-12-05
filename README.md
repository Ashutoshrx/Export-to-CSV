# Export-to-CSV
## Exporting to CSV using OpenCSV and Aparche Common CSV using a generic class.
##A quick differentiation between OpenCsv And Common Csv.


| Feature                                          | Apache Common CSV                        | OpenCsv                                   |
|--------------------------------------------------|-------------------------------------------|-------------------------------------------|
| Headers from Properties file                     | Yes (a little easier than OpenCsv)      | Yes                                       |
| Custom Column Ordering                           | No (default-attributes' name order)      | Yes (default-ascending order sorted)      |
| Sheet name manipulation                          | No                                        | No                                        |
| Handling null cells                              | Set custom value, i.e., '~'               | Cell will be empty                        |
                               









For Reference-
https://stackoverflow.com/questions/45203867/opencsv-how-to-create-csv-file-from-pojo-with-custom-column-headers-and-custom

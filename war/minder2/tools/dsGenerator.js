// This file contains the UI window for the Batch DataSource Generator

isc.DynamicForm.create({
    ID: "isc_generatorForm",
    autoDraw: false,
    margin: 10,
    numCols: 3,
    colWidths: [220, 190, 190],
    fields: [
        { type: "blurb",
          showTitle: false,
          colSpan: 3,
          wrap: true,
          defaultValue: 
          "This tool can generate DataSource definitions from existing database tables, Hibernate " +
          "mappings and Java classes, and save them into your project datasource folder (<code>" + 
          path + "</code>).<ul>" +
          "<li>For database tables, select a database configuration to connect to, and enter a " +
          "comma-separated list of table names in the 'Table names' field</li>" +
          "<li>For Hibernate mappings and/or Java classes, enter a comma-separated list of Hibernate " +
          "entity names or fully-qualified Java class names (eg, bar.foo.ClassName) in the 'class " +
          "names' field</li></ul><p>" +
          "The tool can output XML or JSON, and it can also extract test data from your existing " +
          "database tables.  For full details of all the options, including instructions on how " +
          "to run the tool in pure batch mode, look at file tools/batchDSGenerator.jsp.  This is " +
          "the source code to the tool, and has been designed specifically for you to amend to " +
          "suit your needs."
        },
        { name: "dbName", 
          title: "Database", 
          type: "select", 
          disabled: disableFields,
          defaultValue: dbName
        },
        { name: "schemaName", 
          title: "Schema name (if required)", 
          type: "text", 
          disabled: disableFields,
          defaultValue: schemaName
        },
        { name: "dbLink", 
          linkTitle: "Add new database configuration", 
          visible: !disableFields,
          showTitle: false,
          defaultValue: "adminConsole.jsp",
          _constructor: "LinkItem"
        },
        { name: "tableName", 
          title: "List of table names (comma-separated)", 
          type: "text", 
          width: 340, 
          disabled: disableFields,
          defaultValue: tableName,
          colSpan: 2
        },
        { name: "className", 
          title: "List of class names (comma-separated)", 
          type: "text", 
          width: 340, 
          disabled: disableFields,
          defaultValue: className,
          colSpan: 2
        },
        { name: "outputFormat", 
          title: "Output Format", 
          type: "radioGroup", 
          vertical: false,
          width: 60, 
          valueMap: {xml: "XML", js: "JSON"}, 
          disabled: disableFields, 
          defaultValue: outputFormat,
          colSpan: 2
        },
        { name: "overwrite", 
          title: "Overwrite files if they exist", 
          type: "boolean", 
          disabled: disableFields,
          defaultValue: overwrite,
          colSpan: 2
        },
        { name: "dumpTestData", 
          title: "Also extract table data", 
          type: "boolean", 
          disabled: disableFields,
          defaultValue: dumpTestData,
          colSpan: 2
        },
        { name: "returnSQLType", 
          title: "Include 'sqlType' property on fields retrieved from database metadata", 
          type: "boolean", 
          disabled: disableFields,
          defaultValue: returnSQLType,
          colSpan: 2
        },
        { name: "timestampsAsDates", 
          title: 'Treat JDBC TIMESTAMP columns as type "date" (ignore time value)', 
          type: "boolean", 
          disabled: disableFields,
          defaultValue: timestampsAsDates,
          colSpan: 2
        },
        { name: "ok", 
          title: "OK", 
          type: "button", 
          width: 80, 
          visible: !disableFields, 
          click: function (form, item) {
                var props = form.getValuesAsCriteria();
                for (var propName in props) {
                    if (propName == "tableName" || propName == "className") {
                        props[propName] = props[propName].split(",");
                        // Trim whitespace off the individual table/class names
                        for (var i = 0; i < props[propName].length; i++) {
                            props[propName][i] = props[propName][i].replace(/^\s+|\s+$/g, '')
                        }
                    }
                }
                
                // Let the batch generator know that we came from the UI
                props.fromUI = true;
                                
                isc.HTMLFlow.create({
                    ID: "isc_generatorResults",
                    width: "100%", height: "100%"
                });

                isc_generatorResults.setContentsURL(requestURL, props);
            }
        }
    ]
})

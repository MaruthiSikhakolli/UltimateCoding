import matplotlib.pyplot as plt

# X-values (years)
x_values = [
    2023, 2022, 2021, 2020, 2019, 2018, 2017, 2016, 2015, 2014, 2013, 2012, 2011, 2010,
    2009, 2008, 2007, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997, 1996, 1995,
    1994, 1993, 1992, 1991, 1990, 1989, 1988, 1987, 1986, 1985, 1984, 1983, 1982, 1981,
    1980, 1979, 1978, 1977, 1976, 1975, 1974, 1973, 1972, 1971, 1970, 1969, 1968, 1967, 1966
]

# Y-values (corresponding values in Rs.)
y_values_text = [
    "Rs.64,490", "Rs.52,670.00", "Rs.48,720.00", "Rs.48,651.00", "Rs.35,220.00", "Rs.31,438.00",
    "Rs.29,667.50", "Rs.28,623.50", "Rs.26,343.50", "Rs.28,006.50", "Rs.29,600.00", "Rs.31,050.00",
    "Rs.26,400.00", "Rs.18,500.00", "Rs.14,500.00", "Rs.12,500.00", "Rs.10,800.00", "Rs.7,000.00",
    "Rs.5,850.00", "Rs.5,600.00", "Rs.4,990.00", "Rs.4,300.00", "Rs.4,400.00", "Rs.4,234.00",
    "Rs.4,045.00", "Rs.4,725.00", "Rs.5,160.00", "Rs.4,680.00", "Rs.4,598.00", "Rs.4,140.00",
    "Rs.4,334.00", "Rs.3,466.00", "Rs.3,200.00", "Rs.3,140.00", "Rs.3,130.00", "Rs.2,570.00",
    "Rs.2,140.00", "Rs.2,130.00", "Rs.1,970.00", "Rs.1,800.00", "Rs.1,645.00", "Rs.1,800.00",
    "Rs.1,330.00", "Rs.937.00", "Rs.685.00", "Rs.486.00", "Rs.432.00", "Rs.540.00",
    "Rs.506.00", "Rs.278.50", "Rs.202.00", "Rs.193.00", "Rs.184.00", "Rs.176.00",
    "Rs.162.00", "Rs.102.50", "Rs.83.75", "Rs.71.75", "Rs.63.25"
]

# Cleaning the y-values to convert them to floats
y_values = [float(value.replace('Rs.', '').replace(',', '')) for value in y_values_text]

# Trimming y_values to match the x_values length
y_values = y_values[:len(x_values)]

# Create the plot
plt.figure(figsize=(14, 8))
plt.plot(x_values, y_values, marker='o', linestyle='-', color='b')
plt.xlabel('Year')
plt.ylabel('Value (in Rs.)')
plt.title('Yearly Values')
plt.xticks(rotation=90)
plt.grid(axis='both', linestyle='--', alpha=0.7)
plt.tight_layout()

# Save and show the plot
plt.savefig('year_value_plot.png')
plt.show()
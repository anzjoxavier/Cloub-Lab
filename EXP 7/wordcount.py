from pyspark.sql import SparkSession
from pyspark.sql.functions import explode, split


spark = SparkSession.builder.appName("WordCount").getOrCreate()
df = spark.read.text("file:///home/oem/Nidheesh38/EXP 7/sample4")
words = df.select(explode(split(df.value, ' ')).alias('word'))
word_count = words.groupBy("word").count()
word_count.show()

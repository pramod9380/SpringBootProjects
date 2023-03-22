package com.example.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;
import java.util.function.Function;

@Configuration
@EnableBatchProcessing
public class BatchConfig {


    // 1. Reader class Object

    @Bean
    public FlatFileItemReader<Product> reader(){
        FlatFileItemReader flatFileItemReader = new FlatFileItemReader<>();
        reader().setResource(new ClassPathResource("products.csv"));
        reader().setLineMapper(new DefaultLineMapper  (){{
            setLineTokenizer(new DelimitedLineTokenizer(){{
                setDelimiter(DELIMITER_COMMA);
                setNames("productId","prodCode","prodCost");
            }});

            setFieldSetMapper(new BeanWrapperFieldSetMapper(){{
                setTargetType(Product.class);
            }});
        }});
        return flatFileItemReader;
    }

    @Bean
    public ItemProcessor<Product,Product> processor(){
        return new ProductProcessor();
//        return item -> {
//            double cost = item.getProdCost();
//            item.setProdDisc(cost *12/100.0);
//            item.setProGst(cost *22/100.0);
//            return item;
//        };
    }

    @Autowired
    DataSource dataSource;

    @Bean
    public ItemWriter<? super Object> writer(){
        JdbcBatchItemWriter writer = new JdbcBatchItemWriter<>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO PRODUCTS()");
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider());
        return writer;
    }

    @Bean
    public JobExecutionListener listener(){
        return new MyJobListener();
    }

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step stepA(){
        return stepBuilderFactory.get("stepA")
                .chunk(3)
                .reader(reader())
                .processor((Function<? super Object, ?>) processor())
                .writer(writer())
                .build();
    }

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job jobA(){
        return jobBuilderFactory.get("jobA")
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .start(stepA())
                .build();
    }
}

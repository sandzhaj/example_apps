# Имя финального исполняемого файла
TARGET = my_app

# Компилятор
CC = gcc

# Флаги компилятора
CFLAGS = -Wall -Wextra -g

# Исходные файлы
SRCS = main.c

# Объектные файлы
OBJS = $(SRCS:.c=.o)

# Правило по умолчанию
all: $(TARGET)

# Как собрать исполняемый файл
$(TARGET): $(OBJS)
	$(CC) $(CFLAGS) -o $(TARGET) $(OBJS)

# Как собрать объектный файл
%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

# Очистка
clean:
	rm -f $(OBJS) $(TARGET)